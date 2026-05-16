package com.practise.resillence;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ResilenceController {

	@Autowired
	private RestTemplate template;
	
	
	@GetMapping("/circuitBreaker")
	@CircuitBreaker(name = "circuitBreakerDemo", fallbackMethod = "cricutiBreakerResponse")
	public String getCircuitBreakerData() {
		System.out.println("Inside the getCircuitBreakerData !!");

		String forObject = template.getForObject("http://localhost:9090/bhaskar", String.class);
		return forObject;
	}

	@GetMapping("/retry")
	@Retry(name = "retryApi", fallbackMethod = "retryResponse")
	public String getRetryData() {
		System.out.println("Inside the getRetryData !!");

		String forObject = template.getForObject("http://localhost:9090/bhaskar", String.class);
		return forObject;
	}
	public String cricutiBreakerResponse(Exception ex) {
		System.out.println("Inside the cricutiBreakerResponse !!!!!!!");
	    return "API is not working for Circit breaking: " + ex.getMessage();
	}
	
	public String retryResponse(Exception ex) {
		System.out.println("Inside the retryResponse !!!!!!!");
	    return "API is not working: " + ex.getMessage();
	}
}
