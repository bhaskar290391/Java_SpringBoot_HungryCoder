package com.hungrycoders.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hungrycoders.model.Appointment;
import com.hungrycoders.service.EmailService;

@Component
public class KafkaConsumerListener {

	// Logger for debugging and monitoring
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

	// ObjectMapper for JSON serialization and deserialization
	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	// Service for triggering email notifications
	@Autowired
	private EmailService emailService;

	@KafkaListener(topics = "#{'${spring.kafka.topic.name}'}")
	public void listen(String message) {
		try {
			logger.info("Listening to topic : {}", " ${spring.kafka.topic.name}");
			Appointment appointment = objectMapper.readValue(message, Appointment.class);
			logger.info("Received Appointment | rawMessage : {},parsedJson: {}",message,appointment);
			
			emailService.triggerEmailNotification(appointment);
			logger.info("Email notification sent to appoint with id : {}",appointment.getId());
		} catch (JsonProcessingException e) {
			// Handle JSON parsing errors
			logger.error("Error deserializing message: {}", message, e);
		} catch (Exception ex) {
			// Catch any other unexpected exceptions
			logger.error("Unexpected error while processing message: {}", message, ex);
		}
	}
}
