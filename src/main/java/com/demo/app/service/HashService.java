package com.demo.app.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Service
public class HashService {
    public String hashPassword(String password) {
        try {
            // Generate a salt and hash the password using bcrypt
            String salt = BCrypt.gensalt();
            return BCrypt.hashpw(password, salt);
        } catch (Exception e) {
            return null;
        }
    }
}