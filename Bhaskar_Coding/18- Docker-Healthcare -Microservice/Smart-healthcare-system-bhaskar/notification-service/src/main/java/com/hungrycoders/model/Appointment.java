package com.hungrycoders.model;

import java.time.LocalDateTime;

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
public class Appointment {

	private String id;
	private Patient patient;
	private Doctor doctor;
	private LocalDateTime appointmentTime;
	private AppointmentStatus status;
	private String notes;
	private String doctorComments;

}
