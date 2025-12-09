package com.avsoft.hostelmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI hostelOpenAPI() {
		return new OpenAPI().info(new Info().title("Hostel Management System API")
				.description("APIs for Hostel Management").version("1.0.0"));
	}
}
