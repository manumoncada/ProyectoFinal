package com.example.ProyectoFinal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigurer {
    @Bean(name = "costumCorsConfigurer")
    public WebMvcConfigurer corsConfigConfigurer(){
        return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/api/**")
                    .allowedOrigins("http://18.0.2.2:8080")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
            }
        };
    }
}
