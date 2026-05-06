package com.docker.patient.doctor_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DoctorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorDemoApplication.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
