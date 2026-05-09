package com.hungrycoders.model;

import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

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
@Document(value = "appointments")
public class Appointment {

	@Id
	@Field(targetType = FieldType.STRING)
	private UUID id;

	private Patient patient;

	private Doctor doctor;

	private LocalDateTime appointmentTime;

	private AppointmentStatus status;

	private String notes;
	
	private String doctorComments;
}
