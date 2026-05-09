package com.hungrycoders.payload.request;

import com.hungrycoders.model.DoctorStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class DoctorPayload {

	@NotBlank
	@Size(max = 15, message = "Charater must be 15 or less")
	private String firstName;

	@NotBlank
	@Size(max = 15, message = "Charater must be 15 or less")
	private String lastName;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String phone;

	@NotBlank
	@Size(max = 500, message = "must be 500 characters or less")
	private String speciality;

	@NotNull
	@Min(value = 0L, message = "Must be positive")
	private Integer yeasOfExperience;

	@NotNull(message = "must be provided")
	@ValidEnum(message = "must be valid", enumClass = DoctorStatus.class)
	private String status;
}
