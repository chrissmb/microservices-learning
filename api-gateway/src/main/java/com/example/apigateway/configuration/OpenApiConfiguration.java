package com.example.apigateway.configuration;

import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenApiConfiguration {
	
	private static final String SERVICE_SUFIX = "-service";

	@Bean
	@Lazy(false)
	public CommandLineRunner openApiGroups(
			SwaggerUiConfigParameters config,
			RouteDefinitionLocator locator) {
		return args -> locator.getRouteDefinitions()
				.collectList().block().stream()
				.map(RouteDefinition::getId)
				.filter(path -> path.endsWith(SERVICE_SUFIX))
				.map(path -> path.replaceAll(SERVICE_SUFIX, ""))
				.forEach(config::addGroup);
	}
}
