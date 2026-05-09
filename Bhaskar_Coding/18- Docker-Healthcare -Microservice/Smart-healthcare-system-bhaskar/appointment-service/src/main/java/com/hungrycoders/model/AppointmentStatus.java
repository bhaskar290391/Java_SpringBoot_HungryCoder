package com.hungrycoders.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hungrycoders.exception.InvalidAppointmentStatusException;

public enum AppointmentStatus {
	PENDING, CONFIRMED, REJECTED, COMPLETED;
	
	@JsonCreator
	public static AppointmentStatus fromValue(String value) {
		
		if(value == null || value.isBlank()) {
			throw new InvalidAppointmentStatusException("Status field is required");
		}
		
		for (AppointmentStatus status : AppointmentStatus.values()) {
			
			if(status.name().equalsIgnoreCase(value)) {
				return status;
			}
		}
		
		throw new InvalidAppointmentStatusException("Invalid appointmenr Status value "+ value);
	}
	
	@JsonValue
	public String toValue() {
		return this.name();
	}
}
