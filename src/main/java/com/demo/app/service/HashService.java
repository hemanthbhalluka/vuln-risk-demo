package com.demo.app.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashService {
    public String hashPassword(String password) {
        try {
            // Generate a salt using BCrypt
            String salt = BCrypt.gensalt();
            // Hash the password with the generated salt
            return BCrypt.hashpw(password, salt);
        } catch (Exception e) {
            return null;
        }
    }
}