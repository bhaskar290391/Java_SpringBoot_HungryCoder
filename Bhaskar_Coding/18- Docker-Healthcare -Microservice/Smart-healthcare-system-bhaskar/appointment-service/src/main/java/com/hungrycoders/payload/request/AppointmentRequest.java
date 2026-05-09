package com.hungrycoders.payload.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.hungrycoders.model.AppointmentStatus;

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
public class AppointmentRequest implements Serializable {

	private String id;

	@NotNull(message = "Doctor Id must not be null")
	private UUID doctorId;

	@NotNull(message = "Patient Id must not be null")
	private UUID patientId;

	@NotNull(message = "Appointment time  must not be null")
	private LocalDateTime appointmentTime;

	@NotNull(message = "Status must be provided")
	@ValidEnum(message = "Status must be valid", enumClass = AppointmentStatus.class)
	private String status;
	
	@NotBlank(message = "Notes must not be blank")
	@Size(max = 200,message = "notes must be 200 charcater or less")
	private String notes;
	
	@Size(max = 200,message = "Doctor comments must be 200 charcater or less")
	private String doctorComments;
}
