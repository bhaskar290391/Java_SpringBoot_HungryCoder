package com.hungrycoders.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hungrycoders.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, UUID> {

	Optional<Patient> findByEmail(String email);
}
