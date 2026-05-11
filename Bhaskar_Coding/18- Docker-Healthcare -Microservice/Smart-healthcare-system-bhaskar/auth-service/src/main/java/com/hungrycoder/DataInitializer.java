package com.hungrycoder;

import com.hungrycoder.model.Role;
import com.hungrycoder.model.UserRole;
import com.hungrycoder.payload.request.SignupRequest;
import com.hungrycoder.repository.RoleRepository;
import com.hungrycoder.service.AuthService;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

	private final RoleRepository roleRepository;
	@Autowired
	private AuthService service;

	DataInitializer(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Bean
	public CommandLineRunner initilizeData(RoleRepository roleRepository, MongoTemplate mongoTemplate) {

		return args -> {
			if (!mongoTemplate.collectionExists("roles") || mongoTemplate.findAll(Role.class, "roles").isEmpty()) {

				Role admin = new Role(UserRole.ROLE_ADMIN);
				roleRepository.save(admin);
				System.out.println("Created ROLE_ADMIN");

				Role doctor = new Role(UserRole.ROLE_DOCTOR);
				roleRepository.save(doctor);
				System.out.println("Created ROLE_DOCTOR");

				Role patient = new Role(UserRole.ROLE_PATIENT);
				roleRepository.save(patient);
				System.out.println("Created ROLE_PATIENT");
			} else {
				System.out.println("Roles already exists, skipping role creation");
			}

			if (!mongoTemplate.collectionExists("users")) {
				SignupRequest admin = new SignupRequest("admin", "mudaliyarbhaskar29@gmail.com",
						new HashSet<>(List.of("admin")), "admin123");
				SignupRequest doctor = new SignupRequest("doctor", "mudaliyarbhaskar290391@gmail.com",
						new HashSet<>(List.of("doctor")), "doctor123");
				SignupRequest patient = new SignupRequest("patient", "mudaliyarbhaskar291020@gmail.com",
						new HashSet<>(List.of("patient")), "patient123");

				service.registerUser(admin);
				service.registerUser(doctor);
				service.registerUser(patient);
			} else {
				System.out.println("User already exists , Skipping User creation");
			}

			if (!mongoTemplate.collectionExists("doctors")) {
				Document doctor = new Document().append("firstName", "Bhaskar").append("lastName", "Doctor")
						.append("email", "mudaliyarbhaskar290391@gmail.com").append("phone", "8446548668")
						.append("speiallity", "Gynocologist").append("yearOfExperience", 4)
						.append("status", "AVAILABLE").append("_id", UUID.randomUUID().toString());

				mongoTemplate.insert(doctor, "doctors");
				System.out.println("Insert of doctor is done successfully");

			} else {
				System.out.println("Doctor collection already exsist, Skipping collection");
			}

			if (!mongoTemplate.collectionExists("patients")) {
				Document patient = new Document().append("firstName", "Maddy").append("lastName", "patient")
						.append("email", "mudaliyarbhaskar291020@gmail.com").append("phone", "7506035357")
						.append("age", 30).append("_id", UUID.randomUUID().toString());

				mongoTemplate.insert(patient, "patients");
				System.out.println("Insert of patient is done successfully");

			} else {
				System.out.println("Patient collection already exsist, Skipping collection");
			}

			System.out.println("Data initialization is done ");
		};
	}
}
