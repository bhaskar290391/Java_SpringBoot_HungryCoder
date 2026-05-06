package com.hungrycoders.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

	public static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		logger.info(" Request Method : {}, Request URI  : {}", exchange.getRequest().getMethod(),
				exchange.getRequest().getURI());
		
		return chain.filter(exchange).doFinally(data -> {

			logger.info("Response Status Code  : {}", exchange.getResponse().getStatusCode());
		});

	}

	@Override
	public int getOrder() {

		return Ordered.LOWEST_PRECEDENCE;
	}

}
