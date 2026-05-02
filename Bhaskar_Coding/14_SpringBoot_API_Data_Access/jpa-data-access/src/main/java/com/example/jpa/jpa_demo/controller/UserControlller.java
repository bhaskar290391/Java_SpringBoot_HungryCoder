package com.example.jpa.jpa_demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.jpa_demo.dao.UserService;
import com.example.jpa.jpa_demo.entity.User;

@RestController
@RequestMapping("/users")
public class UserControlller {

	private UserService service;

	public UserControlller(UserService service) {
		super();
		this.service = service;
	}

	@GetMapping("/byLastName")
	public List<User> findUserByLastName(@RequestParam String lastName) {
		return service.findUserByLastName(lastName);
	}

	@GetMapping("/email")
	public User findUserByEmailAddress(@RequestParam String email) {
		return service.findByEmailAddress(email);
	}

	@GetMapping("/native/email")
	public User findUserByEmailAddressByNative(@RequestParam String email) {
		return service.findByEmailAddressByNative(email);
	}
}
