package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
public class TokenService {
    public String generateResetToken() {
        SecureRandom secureRandom = new SecureRandom();
        int token = secureRandom.nextInt(1_000_000); // Generate a random number between 0 and 999999
        return String.format("%06d", token); // Ensure the token is zero-padded to 6 digits
    }
}