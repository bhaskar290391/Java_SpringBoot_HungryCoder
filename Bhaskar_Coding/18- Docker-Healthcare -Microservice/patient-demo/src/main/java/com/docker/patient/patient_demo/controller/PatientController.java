package com.docker.patient.patient_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	@GetMapping("/allPatient")
	public String getAllPatient() {
		System.out.println("Inside the GetAllPatient : Patient Controller");
		return "Patient : All Patient";
	}
	
	
	@GetMapping("/patientById")
	public String getPatientById() {
		System.out.println("Inside the getPatientById : Patient Controller");
		return "Patient : Get All Patient By Id";
	}
}
