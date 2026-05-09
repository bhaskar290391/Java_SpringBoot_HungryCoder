package com.hungrycoders.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hungrycoders.exception.ResourceNotFoundException;
import com.hungrycoders.model.Patient;
import com.hungrycoders.repository.PatientRepository;

@Service
public class PatientService {

	public static final Logger logger = LoggerFactory.getLogger(PatientService.class);

	private PatientRepository repository;

	public PatientService(PatientRepository repository) {
		this.repository = repository;
	}

	public List<Patient> getAllPatient() {
		List<Patient> allPatient = repository.findAll();
		logger.debug("Total number fo patient fetched : {}", allPatient.size());
		return new ArrayList<>(allPatient);
	}

	public Patient getPatientById(String id) {
		Optional<Patient> patient = repository.findById(UUID.fromString(id));

		if (patient.isEmpty()) {
			logger.error("Patient not found with Id :{}", id);
			throw new ResourceNotFoundException("Patient not found !!!");
		}
		logger.info("Patient  found with Id :{}", id);
		return patient.get();
	}

	public Patient getPatientByEmail(String email) {
		Optional<Patient> patient = repository.findByEmail(email);

		if (patient.isEmpty()) {
			logger.error("Patient not found with email :{}", email);
			throw new ResourceNotFoundException("Patient not found !!!");
		}
		logger.info("Patient  found with email :{}", email);
		return patient.get();
	}

	public void deletePatientWithId(String id) {
		UUID patientId = UUID.fromString(id);

		if (!repository.existsById(patientId)) {
			logger.error("Failed to delete patient ,Patient not found with Id :{}", id);
			throw new ResourceNotFoundException("Failed to delete patient ,Patient not found with Id !!!");

		}

		repository.deleteById(patientId);
		logger.info("Patient deleted successfully with id : {}", patientId);
	}

	public Patient savePatient(com.hungrycoders.payload.request.Patient patient) throws RuntimeException {

		Optional<Patient> existingPatient = repository.findByEmail(patient.getEmail());

		if (existingPatient.isPresent()) {
			logger.error("Failed to add patient : Patient with same email id is already exist !!");
			throw new RuntimeException("Failed to add patient : Patient with same email id is already exist !!");
		}

		UUID generatedUUId = UUID.randomUUID();
		Patient patientData = new Patient(generatedUUId, patient.getFirstName(), patient.getLastName(),
				patient.getEmail(), patient.getPhone(), patient.getAge());

		logger.info("Saving the patient with id : {}", generatedUUId);
		return repository.save(patientData);
	}

	public Patient updatePatients(String id, com.hungrycoders.payload.request.Patient patient)
			throws ResourceNotFoundException {

		UUID patientId = UUID.fromString(id);

		Optional<Patient> patientDataFromDataBase = repository.findById(patientId);

		if (patientDataFromDataBase.isEmpty()) {
			logger.error("Failed to update  patient ,Patient not found with Id :{}", id);
			throw new ResourceNotFoundException("Failed to delete patient ,Patient not found with Id !!!");
		}

		Patient patientInfo = patientDataFromDataBase.get();
		patientInfo.setId(patientId);
		patientInfo.setFirstName(patient.getFirstName());
		patientInfo.setLastName(patient.getLastName());
		patientInfo.setEmail(patient.getEmail());
		patientInfo.setPhone(patient.getPhone());
		patientInfo.setAge(patient.getAge());

		logger.info("Updating the patient with id : {}", patientInfo.getId());
		return repository.save(patientInfo);
	}
}
