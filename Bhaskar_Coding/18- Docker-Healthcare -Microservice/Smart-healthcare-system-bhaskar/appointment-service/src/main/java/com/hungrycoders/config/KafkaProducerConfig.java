package com.hungrycoders.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@Configuration
public class KafkaProducerConfig {

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(Environment environment) {
		return new KafkaTemplate<>(producerFactory(environment));
	}

	@Bean
	public ProducerFactory<String, String> producerFactory(Environment environment) {

		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				environment.getProperty("spring.kafka.producer.bootstrap-servers"));
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs);
	}
}
