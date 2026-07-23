package com.demo.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.enable()) // Enable CSRF protection
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").authenticated() // Restrict access to admin endpoints
                .anyRequest().authenticated() // Require authentication for all other requests
            );
        return http.build();
    }
}