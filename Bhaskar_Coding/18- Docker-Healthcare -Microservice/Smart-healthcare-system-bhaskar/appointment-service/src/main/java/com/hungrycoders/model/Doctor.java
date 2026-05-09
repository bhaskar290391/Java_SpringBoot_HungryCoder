package com.hungrycoders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Doctor {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String speciality;
	private Integer yearsOfExperience;
	private String status;
}
