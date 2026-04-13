package com.cjrock.geo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestão Escolar Pública")
                        .version("1.0.0")
                        .description("Documentação completa da API para o sistema de gestão de escolas públicas.")
                        .contact(new Contact()
                                .name("Carlos Joubert") // Seu nome
                                .email("carlosjoubert@gmail.com") // Seu e-mail
                                .url("https://github.com/carlosjoubert/escola_publica"))); // Link do seu repositório
    }
}