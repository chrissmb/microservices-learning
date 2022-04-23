package com.example.bookservice.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

/**
 * @author Chris
 * http://localhost:8100/swagger-ui.html
 */
@OpenAPIDefinition(info = @Info(
		title = OpenApiConfiguration.TITLE, 
		version = OpenApiConfiguration.VERSION, 
		description = "Documentation of Book Service API"))
public class OpenApiConfiguration {
	
	public static final String TITLE = "Book Service API";
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
