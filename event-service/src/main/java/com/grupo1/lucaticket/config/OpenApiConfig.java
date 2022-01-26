package com.grupo1.lucaticket.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI StudentOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("LucaTicket")
                        .description("Documentación de la API Eventos")
                        .version("v1.0")
                        .contact(new Contact().name("Grupo1").
                                url("https://grupo1.es").email("grupo1@elmejor.es"))
                        .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("API que proveé de datos sobre eventos musicales")
                        .url("https://grupo1.es"));
    }

}
