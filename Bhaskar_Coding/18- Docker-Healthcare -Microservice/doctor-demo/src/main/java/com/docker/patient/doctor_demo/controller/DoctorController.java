package com.docker.patient.doctor_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DoctorController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/allDoctor")
	public String getAllDoctor() {
		return "Docktor : All Doctor";
	}

	@GetMapping("/allPatientFormDoctors")
	public String getAllPatientFromDoctor() {

		System.out.println("Iside the getAllPatientFromDoctor : Doctor Controller");
		String patient = template.getForObject("http://patient-service:8080/allPatient", String.class);
		return patient;
	}

}
