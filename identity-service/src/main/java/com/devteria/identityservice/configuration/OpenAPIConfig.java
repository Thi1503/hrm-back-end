package com.devteria.identityservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition(
        info =
                @io.swagger.v3.oas.annotations.info.Info(
                        title = "Identity Service",
                        version = "v0.0.1",
                        description = "Identity Service API"),
        security = {@SecurityRequirement(name = "bearerAuth")})
@SecurityScheme(
        name = "bearerAuth", // Tên tham chiếu trong @SecurityRequirement
        type = SecuritySchemeType.HTTP, // Kiểu HTTP Auth
        scheme = "bearer", // Dạng Bearer token
        bearerFormat = "JWT" // Định dạng token JWT
        )
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Identity Service")
                        .description("Identity Service API")
                        .version("v0.0.1"));
    }
}
