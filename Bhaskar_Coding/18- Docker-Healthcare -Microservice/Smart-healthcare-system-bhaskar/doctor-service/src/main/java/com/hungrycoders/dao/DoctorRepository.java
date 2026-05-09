package com.hungrycoders.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hungrycoders.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, UUID> {

	Optional<Doctor> findByEmail(String email);
}
