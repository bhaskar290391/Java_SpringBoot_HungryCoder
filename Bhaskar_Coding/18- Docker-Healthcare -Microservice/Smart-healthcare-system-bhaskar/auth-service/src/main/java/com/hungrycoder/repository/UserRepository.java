package com.hungrycoder.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hungrycoder.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);
}
