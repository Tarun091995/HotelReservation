package com.myproduct.reservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.myproduct.reservation")
@EnableSwagger2
@CrossOrigin(origins = "http://localhost:4200")
public class ResturantReservation {
    public static void main(String args[])
    {
        SpringApplication.run(ResturantReservation.class, args);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST","PUT","DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.canSerialize(LocalDateTime.class);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }
}
