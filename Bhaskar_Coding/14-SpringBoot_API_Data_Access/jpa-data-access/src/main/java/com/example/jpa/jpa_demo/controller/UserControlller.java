package com.example.jpa.jpa_demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public void createUser(@RequestBody User user) {
		service.createUser(user);
		System.out.println("User created Successfully");
	}

	@GetMapping("/{id}")
	public User FindUserById(@PathVariable long id) {
		return service.findById(id);
	}

	@GetMapping()
	public List<User> findAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping("/native/findAll")
	public List<User> findAllUsersNative() {
		return service.findAllUsersByNative();
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		User user = service.findById(id);
		service.deleteByUser(user);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user ) {
		return service.updateUser(user);
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
