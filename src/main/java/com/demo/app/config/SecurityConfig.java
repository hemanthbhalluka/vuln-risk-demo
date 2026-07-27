package com.demo.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.enable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // Allow public access to specific endpoints
                .anyRequest().authenticated() // Require authentication for all other endpoints
            )
            .formLogin()
            .and()
            .httpBasic(); // Enable basic authentication for API access
        return http.build();
    }
}