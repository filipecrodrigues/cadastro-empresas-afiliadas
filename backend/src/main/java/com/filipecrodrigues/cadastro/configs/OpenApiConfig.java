package com.filipecrodrigues.cadastro.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuração global do Swagger
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Cadastro de Empresas Afiliadas")
                        .version("1.0")
                        .description("API REST para cadastro e gerenciamento de empresas afiliadas"));
    }
}
