package com.hungrycoders.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hungrycoders.exception.ResourceNotFoundException;
import com.hungrycoders.model.Appointment;
import com.hungrycoders.model.AppointmentStatus;
import com.hungrycoders.model.Doctor;
import com.hungrycoders.model.Patient;
import com.hungrycoders.payload.request.AppointmentRequest;
import com.hungrycoders.payload.response.GenericResponse;
import com.hungrycoders.repository.AppointmentRepository;

@Service
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;

	@Value("${app.environment}")
	private String environment;

	@Autowired
	private AppointmentRepository respository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${doctor.service.url}")
	private String doctorServiceUrl;

	@Value("${patient.service.url}")
	private String patientServiceUrl;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${spring.kafka.topic.name}")
	private String topicName;

	private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

	AppointmentService(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	public String bookAppointment(AppointmentRequest appointment) {
		try {

			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());

			Doctor doctors = fetchDoctorDetails(appointment.getDoctorId().toString());
			logger.info("fetched Doctor details inside the appointment : {}", mapper.writeValueAsString(doctors));

			Patient patient = fetchPatientDetails(appointment.getPatientId().toString());
			logger.info("fetched Patient details inside the appointment : {}", mapper.writeValueAsString(patient));

			UUID generatedID = UUID.randomUUID();
			Appointment appointments = new Appointment();
			appointments.setId(generatedID);
			appointments.setDoctor(doctors);
			appointments.setPatient(patient);
			appointments.setAppointmentTime(appointment.getAppointmentTime());
			appointments.setNotes(appointment.getNotes());
			appointments.setDoctorComments(appointment.getDoctorComments());
			appointments.setStatus(AppointmentStatus.PENDING);

			String appointmentId = String.valueOf(respository.save(appointments).getId());

			String appointmentJson = mapper.writeValueAsString(appointments);

			sendEventToKafka(appointmentJson);
			return appointmentId;
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error booking appointment " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public String updateAppointment(AppointmentRequest appointmentRequest) {
		try {
			Appointment existingAppointment = appointmentRepository
					.findById(UUID.fromString(appointmentRequest.getId()))
					.orElseThrow(() -> new ResourceNotFoundException(
							"Appointment not found with ID" + appointmentRequest.getId()));

			Map<String, Object> doctor = restTemplate
					.getForObject(doctorServiceUrl + "/" + appointmentRequest.getDoctorId(), Map.class);
			Map<String, Object> patient = restTemplate
					.getForObject(patientServiceUrl + "/" + appointmentRequest.getPatientId(), Map.class);

			if (doctor == null || doctor.isEmpty()) {
				throw new ResourceNotFoundException(
						"Doctor with id is not present " + appointmentRequest.getDoctorId());
			}

			if (patient == null || patient.isEmpty()) {
				throw new ResourceNotFoundException(
						"Patient with id is not present " + appointmentRequest.getPatientId());
			}

			Map<String, Object> doctorData = (Map<String, Object>) doctor.get("data");
			// Manually create a Doctor object from the Map

			Doctor doctor1 = new Doctor();
			doctor1.setId((String) doctorData.get("id"));
			doctor1.setFirstName((String) doctorData.get("firstName"));
			doctor1.setLastName((String) doctorData.get("lastName"));
			doctor1.setEmail((String) doctorData.get("email"));
			doctor1.setPhone((String) doctorData.get("phone"));
			doctor1.setSpeciality((String) doctorData.get("speciality"));
			doctor1.setYearsOfExperience((Integer) doctorData.get("yearsOfExperience"));
			doctor1.setStatus((String) doctorData.get("status"));

			Map<String, Object> patientData = (Map<String, Object>) patient.get("data");
			Patient patient1 = new Patient();
			patient1.setId((String) patientData.get("id"));
			patient1.setFirstName((String) patientData.get("firstName"));
			patient1.setLastName((String) patientData.get("lastName"));
			patient1.setEmail((String) patientData.get("email"));
			patient1.setPhone((String) patientData.get("phone"));
			patient1.setAge((Integer) patientData.get("age"));

			existingAppointment.setDoctor(doctor1);
			existingAppointment.setPatient(patient1);
			existingAppointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
			existingAppointment.setNotes(appointmentRequest.getNotes());
			existingAppointment.setDoctorComments(appointmentRequest.getDoctorComments());
			existingAppointment.setStatus(AppointmentStatus.fromValue(appointmentRequest.getStatus()));

			String apppointId = String.valueOf(respository.save(existingAppointment).getId());

			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());

			String appointmentJson = mapper.writeValueAsString(existingAppointment);

			sendEventToKafka(appointmentJson);
			return apppointId;

		} catch (Exception e) {
			throw new ResourceNotFoundException("Error updating appointment " + e.getMessage());
		}
	}

	public List<Appointment> getDoctorById(String doctorId) {
		return respository.findByDoctorId(doctorId, Sort.by(Direction.ASC, "appointmentTime"));
	}

	public List<Appointment> getByPatientId(String patientId) {
		return respository.findByPatientId(patientId, Sort.by(Sort.Direction.ASC, "appointmentTime"));
	}

	public List<Appointment> getAllAppointments() {
		return respository.findAllByOrderByAppointmentTimeAsc();
	}

	private boolean isDevelopmentEnvironment() {
		return "dev".equalsIgnoreCase(environment);
	}

	private Doctor fetchDoctorDetails(String doctorId) {

		if (isDevelopmentEnvironment()) {
			return new Doctor(doctorId, "John", "Doe", "doctorhungrycoders@gmail.com", "1234567890", "Cardiology", 10,
					"ACTIVE");
		}

		ResponseEntity<GenericResponse<Doctor>> exchange = restTemplate.exchange(doctorServiceUrl + "/" + doctorId,
				HttpMethod.GET, null, new ParameterizedTypeReference<GenericResponse<Doctor>>() {
				});

		GenericResponse<Doctor> body = exchange.getBody();

		if (body != null && body.getData() != null) {
			return body.getData();
		}

		throw new ResourceNotFoundException("Doctor not found with id : " + doctorId);
	}

	private Patient fetchPatientDetails(String patientId) {

		if (isDevelopmentEnvironment()) {
			return new Patient(patientId, "Jane", "Smith", "jane.smith@example.com", "0987654321", 30);
		}

		ResponseEntity<GenericResponse<Patient>> exchange = restTemplate.exchange(patientServiceUrl + "/" + patientId,
				HttpMethod.GET, null, new ParameterizedTypeReference<GenericResponse<Patient>>() {
				});

		GenericResponse<Patient> body = exchange.getBody();

		if (body != null && body.getData() != null) {
			return body.getData();
		}

		throw new ResourceNotFoundException("Patient not found with id : " + patientId);
	}

	private void sendEventToKafka(String appointmentJson) {
		CompletableFuture<SendResult<String, String>> completablefeature = kafkaTemplate.send(topicName,
				appointmentJson);

		completablefeature.whenComplete((result, exception) -> {

			if (exception == null) {
				RecordMetadata metadata = result.getRecordMetadata();
				logger.info("Message sent to topic : {} successfully ", topicName);
				logger.info("partition : {}, offset : {} ", metadata.partition(), metadata.offset());
			} else {
				logger.error("Failed to sent message to topic : {} ", topicName);
				logger.error(exception.getMessage());
			}
		});
	}

}
