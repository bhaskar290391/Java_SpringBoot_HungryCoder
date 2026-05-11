package com.hungrycoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungrycoder.payload.request.LoginRequest;
import com.hungrycoder.payload.request.SignupRequest;
import com.hungrycoder.payload.response.JwtResponse;
import com.hungrycoder.payload.response.MessageResponse;
import com.hungrycoder.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

	@Autowired
	private AuthService service;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request) {

		JwtResponse response = service.authenticateUser(request);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest request) {
		MessageResponse messageResponse = service.registerUser(request);

		if (messageResponse.message().startsWith("Error: ")) {
			return ResponseEntity.badRequest().body(messageResponse);
		}

		return ResponseEntity.ok(messageResponse);
	}

}
