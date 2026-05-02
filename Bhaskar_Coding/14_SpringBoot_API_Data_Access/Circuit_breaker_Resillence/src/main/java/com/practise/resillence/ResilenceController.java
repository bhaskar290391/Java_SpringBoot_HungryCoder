package com.practise.resillence;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ResilenceController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/retry")
	@Retry(name = "retryApi", fallbackMethod = "retryResponse")
	public String getRetryData() {
		System.out.println("Inside the getRetryData !!");

		String forObject = template.getForObject("http://localhost:9090/bhaskar", String.class);
		return forObject;
	}
	public String retryResponse(Exception ex) {
		System.out.println("Inside the retryResponse !!!!!!!");
	    return "API is not working: " + ex.getMessage();
	}
}
