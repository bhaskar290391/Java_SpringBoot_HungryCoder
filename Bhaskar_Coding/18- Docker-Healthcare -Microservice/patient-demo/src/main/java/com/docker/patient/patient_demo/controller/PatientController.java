package com.docker.patient.patient_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	@GetMapping("/allPatient")
	public String getAllPatient() {
		return "Patient : All Patient";
	}
	
	
	@GetMapping("/patientById")
	public String getPatientById() {
		return "Patient : Get All Patient By Id";
	}
}
