package com.hungrycoders.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungrycoders.model.Appointment;
import com.hungrycoders.payload.request.AppointmentRequest;
import com.hungrycoders.service.AppointmentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api.v1/appointments")
public class AppointmentController {

	public static Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	private AppointmentService service;

	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<?> getAppointmentByDoctorId(@PathVariable String doctorId) {
		logger.info("Fetching appointmnet of Doctor with id : {}", doctorId);
		try {
			List<Appointment> doctorData = service.getDoctorById(doctorId);
			logger.info("Appointment fetched successfully for doctor Id : {}" + doctorId);
			return ResponseEntity.ok(doctorData);
		} catch (Exception e) {
			logger.error("Error while fetching appointment of Doctor with {}" + doctorId);
			return ResponseEntity.internalServerError().body("Unable to fetch appointments");

		}
	}

	@GetMapping("/patient/{patientId}")
	public ResponseEntity<?> getAppointmentByPatientId(@PathVariable String patientId) {
		logger.info("Fetching appointmnet of Patient with id : {}", patientId);
		try {
			List<Appointment> patientData = service.getByPatientId(patientId);
			logger.info("Appointment fetched successfully for Patient Id : {}" + patientId);
			return ResponseEntity.ok(patientData);
		} catch (Exception e) {
			logger.error("Error while fetching appointment of Patient with {}" + patientId);
			return ResponseEntity.internalServerError().body("Unable to fetch appointments");

		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllAppointment() {
		logger.info("Fetching all appointments ");
		try {
			List<Appointment> appointments = service.getAllAppointments();
			logger.info("All Appointment fetched successfully ");
			return ResponseEntity.ok(appointments);
		} catch (Exception e) {
			logger.error("Error while fetching all appointment");
			return ResponseEntity.internalServerError().body("Unable to fetch appointments");

		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> createAppointment(@Valid @RequestBody AppointmentRequest request) {
		logger.info("booking appointment : {} ", request);
		try {
			String bookAppointment = service.bookAppointment(request);
			logger.info("Appointment booked successfully");
			return ResponseEntity.ok("Appointment booked successfully with id " + bookAppointment);
		} catch (Exception e) {
			logger.error("Error while saving  appointment");
			return ResponseEntity.internalServerError().body("Error while saving  appointment");
		}
	}

	@PutMapping
	public ResponseEntity<?> updateAppointment(@Valid @RequestBody AppointmentRequest request) {
		logger.info("updaing appointment : {} ", request);
		try {
			String updateAppointment = service.updateAppointment(request);
			logger.info("Appointment updated successfully");
			return ResponseEntity.ok("Appointment updated successfully with id " + updateAppointment);
		} catch (Exception e) {
			logger.error("Error while updaing  appointment");
			return ResponseEntity.internalServerError().body("Error while saving  appointment");
		}
	}
}
