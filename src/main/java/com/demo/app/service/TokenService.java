package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
public class TokenService {
    public String generateResetToken() {
        SecureRandom secureRandom = new SecureRandom();
        int token = secureRandom.nextInt(999999);
        return String.format("%06d", token);
    }
}