package com.hungrycoders.exception;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Component
public class CustomExceptionHandler implements ErrorWebExceptionHandler {

	public final ObjectMapper mapper = new ObjectMapper();

	@Override
	public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.put("error", "Internal Server Error");
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("path", exchange.getRequest().getPath().value());

		String errorResponse;
		try {
			errorResponse = mapper.writeValueAsString(errorDetails);
		} catch (Exception e) {
			errorResponse = "{\"error\":\"Failed to serialize error details\"}";
		}

		exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

		// Write the error response
		DataBufferFactory bufferFactory = exchange.getResponse().bufferFactory();
		return exchange.getResponse()
				.writeWith(Mono.just(bufferFactory.wrap(errorResponse.getBytes(StandardCharsets.UTF_8))));
		
	}

}
