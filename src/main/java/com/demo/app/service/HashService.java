package com.demo.app.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashService {

    private final BCryptPasswordEncoder passwordEncoder;

    public HashService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String hashPassword(String password) {
        try {
            return passwordEncoder.encode(password);
        } catch (Exception e) {
            // Log the exception and return null or handle it as per application requirements
            return null;
        }
    }
}