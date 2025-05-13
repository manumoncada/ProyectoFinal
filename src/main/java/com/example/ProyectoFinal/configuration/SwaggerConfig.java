package com.example.ProyectoFinal.configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configurerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api prueba")
                        .version("1.0")
                        .description("Documentacion de las Apis")
                        .contact(new Contact()
                                .name("soporte API")
                                .email("juan.moncada-f@gmail.com")
                        )
                );
    }
}
