package com.example.naumentest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NaumenTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaumenTestApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/name/").allowedOrigins("http://localhost:8080");
                registry.addMapping("/stats/requests").allowedOrigins("http://localhost:8080");
                registry.addMapping("/stats/max-age").allowedOrigins("http://localhost:8080");
                registry.addMapping("/load-file/").allowedOrigins("http://localhost:8080");
            }
        };
    }

}
