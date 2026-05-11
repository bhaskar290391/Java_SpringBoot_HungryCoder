package com.hungrycoders.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.hungrycoders.model.Appointment;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	// Kafka broker address
	@Value("${spring.kafka.consumer.bootstrap-servers}")
	private String kafkaAddress;

	// Consumer group ID for Kafka
	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Appointment> KafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, Appointment> data = new ConcurrentKafkaListenerContainerFactory<>();
		data.setConsumerFactory(consumerFactory());
		data.setConcurrency(3);
		data.getContainerProperties().setPollTimeout(3000);
		return data;
	}

	@Bean
	public ConsumerFactory<String, Appointment> consumerFactory() {
		Map<String, Object> props = new HashMap();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress); // Kafka broker address
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId); // Consumer group ID
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // Key deserialization
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // Value deserialization
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false); // Disable auto-commit for better control
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		return new DefaultKafkaConsumerFactory<>(props);
	}
}
