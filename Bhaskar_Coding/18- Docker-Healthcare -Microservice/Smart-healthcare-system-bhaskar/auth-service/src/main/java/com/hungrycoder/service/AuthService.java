package com.hungrycoder.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hungrycoder.model.Role;
import com.hungrycoder.model.User;
import com.hungrycoder.model.UserRole;
import com.hungrycoder.payload.request.LoginRequest;
import com.hungrycoder.payload.request.SignupRequest;
import com.hungrycoder.payload.response.JwtResponse;
import com.hungrycoder.payload.response.MessageResponse;
import com.hungrycoder.repository.RoleRepository;
import com.hungrycoder.repository.UserRepository;
import com.hungrycoder.security.jwt.JwtUtils;
import com.hungrycoder.security.services.UserDetailsImpl;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

	public JwtResponse authenticateUser(LoginRequest request) {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

		SecurityContextHolder.getContext().setAuthentication(authenticate);

		String jwt = jwtUtils.generateJWTToken(authenticate);

		UserDetailsImpl serviceimpl = (UserDetailsImpl) authenticate.getPrincipal();

		List<String> roles = serviceimpl.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return new JwtResponse(jwt, serviceimpl.getId(), serviceimpl.getUsername(), serviceimpl.getEmail(), roles);
	}

	public MessageResponse registerUser(SignupRequest request) {

		if (userRepository.existsByUsermame(request.username())) {
			return new MessageResponse("Error: Username is already exists");
		}

		if (userRepository.existsByEmail(request.eamil())) {
			return new MessageResponse("Error: Email is already exists");
		}

		User user = new User(request.username(), request.eamil(), encoder.encode(request.password()));

		Set<String> strRoles = request.roles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(UserRole.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
			roles.add(userRole);

		} else {
			strRoles.forEach(role -> {

				switch (role) {
				case "admin":
					Role userRole = roleRepository.findByName(UserRole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(userRole);
					break;

				case "doctor":
					Role doctor = roleRepository.findByName(UserRole.ROLE_DOCTOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(doctor);
					break;

				default:
					Role patient = roleRepository.findByName(UserRole.ROLE_PATIENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(patient);
					break;
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		return new MessageResponse("User registered successfully!");
	}
}
