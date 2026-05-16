package com.practise.resillence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.resilience.annotation.EnableResilientMethods;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.RetryRegistry;

@SpringBootApplication
@EnableResilientMethods
public class CircuitBreakerResillenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerResillenceApplication.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Bean
	public RetryRegistry retryRegistry() {
	    RetryRegistry registry = RetryRegistry.ofDefaults();
	    registry.retry("retryApi").getEventPublisher()
	            .onRetry(event -> System.out.println("Retry attempt #" + event.getNumberOfRetryAttempts()));
	    return registry;
	}

}
