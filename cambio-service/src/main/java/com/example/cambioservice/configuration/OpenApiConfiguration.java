package com.example.cambioservice.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

/**
 * @author Chris
 * http://localhost:8000/swagger-ui.html
 */
@OpenAPIDefinition(info = @Info(
		title = OpenApiConfiguration.TITLE, 
		version = OpenApiConfiguration.VERSION, 
		description = "Documentation of Cambio Service API"))
public class OpenApiConfiguration {
	
	public static final String TITLE = "Cambio Service API";
	public static final String VERSION = "1.0";

	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info()
						.title(TITLE)
						.version(VERSION)
						.license(new License()
								.name("Nome licença")
								.url("http://springdoc.org")
						)
				);
	}
}