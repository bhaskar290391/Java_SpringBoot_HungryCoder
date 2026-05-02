package com.example.jpa.jpa_demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfiguration {

	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Bean
	public DataSource source() {
		System.out.println("Inside the datsource Configuration");
		DataSourceBuilder<?> data= DataSourceBuilder.create();
		data.username(userName);
		data.password(password);
		data.url(url);
		data.driverClassName(driverClassName);
		
		return data.build();
		
	}
}
