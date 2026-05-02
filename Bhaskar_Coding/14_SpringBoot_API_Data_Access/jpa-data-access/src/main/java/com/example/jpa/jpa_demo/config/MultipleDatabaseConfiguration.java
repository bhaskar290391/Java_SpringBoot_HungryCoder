package com.example.jpa.jpa_demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
public class MultipleDatabaseConfiguration {

	
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource primary() {
		System.out.println("Inside the datsource Configuration");
		DataSourceBuilder<?> data= DataSourceBuilder.create();
		return data.build();
		
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource secondary() {
		System.out.println("Inside the datsource Configuration");
		DataSourceBuilder<?> data= DataSourceBuilder.create();
		return data.build();
		
	}
}
