package com.demo.app.service;
// VULN: CWE-330 (MEDIUM) - Insecure randomness: java.util.Random used for a reset token
import org.springframework.stereotype.Service;
import java.util.Random;
@Service
public class TokenService {
    public String generateResetToken() {
        Random random = new Random();
        int token = random.nextInt(999999);
        return String.format("%06d", token);
    }
}