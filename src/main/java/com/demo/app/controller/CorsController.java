package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RestController
@RequestMapping("/api/public")
public class CorsController {
    @GetMapping("/data")
    public String getData() {
        return "Public Data";
    }
}

@Configuration
class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("https://trusted-domain.com"); // Specify trusted domains
        config.addAllowedHeader("Content-Type"); // Specify allowed headers
        config.addAllowedMethod("GET"); // Specify allowed methods
        source.registerCorsConfiguration("/api/public/**", config);
        return new CorsFilter(source);
    }
}