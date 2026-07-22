package com.demo.app.service;
// VULN: CWE-327 (MEDIUM) - Weak hash (unsalted MD5) used for password storage
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.util.Base64;
@Service
public class HashService {
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            return null;
        }
    }
}