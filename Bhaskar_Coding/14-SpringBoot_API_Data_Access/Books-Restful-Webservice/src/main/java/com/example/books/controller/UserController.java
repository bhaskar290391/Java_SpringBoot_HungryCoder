package com.example.books.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.entity.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@PostMapping()
	public String addUser(@Valid @RequestBody User user) {
		return "User Register successfully";
	}
}
