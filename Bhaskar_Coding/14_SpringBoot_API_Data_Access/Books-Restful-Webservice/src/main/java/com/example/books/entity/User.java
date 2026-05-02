package com.example.books.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
	String name;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be of proper format")
	String email;

	@Min(value = 18, message = "Age must be equal or greater than 18")
	int age;

	public User(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
