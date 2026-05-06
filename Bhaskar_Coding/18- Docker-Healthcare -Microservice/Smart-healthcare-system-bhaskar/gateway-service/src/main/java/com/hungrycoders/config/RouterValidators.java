package com.hungrycoders.config;

import java.util.Set;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouterValidators {

	public static final Set<String> openApiEndPoints = Set.of("api/auth/register", "api/auth/signin");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndPoints.stream()
			.noneMatch(url -> request.getURI().getPath().contains(url));

}
