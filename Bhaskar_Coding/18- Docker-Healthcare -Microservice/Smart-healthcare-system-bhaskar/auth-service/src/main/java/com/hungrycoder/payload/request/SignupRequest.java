package com.hungrycoder.payload.request;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignupRequest(

		@NotBlank(message = "Username must not be blank") @Size(min = 3, max = 20, message = "Username must be between 3 to 20 charcters") String username,

		@NotBlank(message = "Email must not be blank") @Size(max = 50, message = "Email must not exceed 50 characters") @Email(message = "Invalid Email Format") String eamil,

		@NotNull(message = "Roles cannot be null") @Size(min = 1, message = "Minimum one role need to be specified") Set<String> roles,

		@NotBlank(message = "Password must not be blank") @Size(min = 6, max = 40, message = "password should be between 6 and 40 characters") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@$!%*?&#])(?=.*\\d)[A-Za-z\\d@$!%*?&#]{6,40}$", message = "Password must include at least one uppercase letter, one number, and one special character.") String password) {

}
