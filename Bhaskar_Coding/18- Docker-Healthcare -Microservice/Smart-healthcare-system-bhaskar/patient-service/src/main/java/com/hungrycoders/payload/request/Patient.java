package com.hungrycoders.payload.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;

public class Patient implements Serializable{

	@NotBlank
	@Size(max = 15,message = "Must be 15 character or less")
	private String firstName;
	
	@NotBlank
	@Size(max = 15,message = "Must be 15 character or less")
	private String lastName;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String phone;
	
	@NotNull
	@Min(value = 0,message = "Age cannot be less than 0")
	@Max(value = 100,message = "Age cannot be greater than 100")
	private Integer age;

	public Patient(@NotBlank @Size(max = 15, message = "Must be 15 character or less") String firstName,
			@NotBlank @Size(max = 15, message = "Must be 15 character or less") String lastName, @NotBlank String email,
			@NotBlank String phone,
			@NotNull @Min(value = 0, message = "Age cannot be less than 0") @Max(value = 100, message = "Age cannot be greater than 100") Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.age = age;
	}
	
	public Patient() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
