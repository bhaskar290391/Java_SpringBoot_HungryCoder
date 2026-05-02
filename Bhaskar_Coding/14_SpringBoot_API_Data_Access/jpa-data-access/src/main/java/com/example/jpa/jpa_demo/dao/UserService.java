package com.example.jpa.jpa_demo.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jpa.jpa_demo.entity.User;

@Service
public class UserService {

	private UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> findUserByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}

	public User findByEmailAddress(String email) {
		return repository.findByEmailAdrress(email);
	}
	
	public User findByEmailAddressByNative(String email) {
		return repository.findByEmailAdrressByNative(email);
	}
}
