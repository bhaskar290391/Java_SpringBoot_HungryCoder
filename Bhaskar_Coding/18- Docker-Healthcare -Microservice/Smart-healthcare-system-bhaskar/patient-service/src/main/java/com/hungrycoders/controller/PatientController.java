package com.hungrycoders.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungrycoders.model.Patient;
import com.hungrycoders.payload.response.GenericResponse;
import com.hungrycoders.service.PatientService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value = "/api/v1/patient")
public class PatientController {

	public static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	private PatientService service;

	public PatientController(PatientService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPatientById(@PathVariable String id) {
		try {

			Patient patientById = service.getPatientById(id);
			return ResponseEntity.status(200).body(new GenericResponse<>("Patient Fetched Successfully", patientById));
		} catch (Exception e) {

			logger.error("Error while fetching patient by id :{} {}", id, e.getMessage());
			String errorMessage = "Error While fetching patient : ";
			if (e.getMessage() != null && !e.getMessage().isBlank()) {
				errorMessage += e.getMessage();
			}
			return ResponseEntity.status(500).body(new GenericResponse<>(errorMessage));
		}
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<?> getPatientByEmail(@PathVariable String email) {
		try {

			Patient patientByEmail = service.getPatientByEmail(email);
			return ResponseEntity.status(200)
					.body(new GenericResponse<>("Patient Fetched Successfully", patientByEmail));
		} catch (Exception e) {

			logger.error("Error while fetching patient by email :{} {}", email, e.getMessage());
			String errorMessage = "Error While fetching patient : ";
			if (e.getMessage() != null && !e.getMessage().isBlank()) {
				errorMessage += e.getMessage();
			}
			return ResponseEntity.status(500).body(new GenericResponse<>(errorMessage));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllPatient() {
		try {

			List<Patient> allPatient = service.getAllPatient();
			return ResponseEntity.status(200).body(new GenericResponse<>("Patient Fetched Successfully", allPatient));
		} catch (Exception e) {

			logger.error("Error while fetching all patient :{} ", e.getMessage());
			String errorMessage = "Error While fetching all patient : ";
			if (e.getMessage() != null && !e.getMessage().isBlank()) {
				errorMessage += e.getMessage();
			}
			return ResponseEntity.status(500).body(new GenericResponse<>(errorMessage));
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> savePatient(@Valid @RequestBody com.hungrycoders.payload.request.Patient patient) {
		try {
			Patient savePatient = service.savePatient(patient);
			return ResponseEntity.status(201).body(new GenericResponse<>("Patient Saved sucessfully", savePatient));
		} catch (Exception e) {
			logger.error("Error saving patient: {}", e.getMessage());
			return ResponseEntity.status(500).body(new GenericResponse<>("Error saving patient"));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePatient(String id,
			@Valid @RequestBody com.hungrycoders.payload.request.Patient patient) {
		try {
			Patient savePatient = service.updatePatients(id, patient);
			return ResponseEntity.status(201).body(new GenericResponse<>("Patient Updated sucessfully", savePatient));
		} catch (Exception e) {
			logger.error("Error Updating  patient: {}", e.getMessage());
			return ResponseEntity.status(500).body(new GenericResponse<>("Error Updating patient"));
		}
	}

}
