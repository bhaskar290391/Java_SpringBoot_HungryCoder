package com.docker.patient.doctor_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

	@GetMapping("/allDoctor")
	public String getAllDoctor() {
		return "Docktor : All Doctor";
	}
	
	
	
}
