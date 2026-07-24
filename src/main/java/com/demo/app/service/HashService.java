package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Service
public class HashService {
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    public String hashPassword(String password) {
        try {
            // Generate a random salt
            byte[] salt = new byte[16];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(salt);

            // Use PBKDF2 with HMAC-SHA256 for hashing
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = keyFactory.generateSecret(spec).getEncoded();

            // Combine salt and hash for storage
            byte[] saltAndHash = new byte[salt.length + hash.length];
            System.arraycopy(salt, 0, saltAndHash, 0, salt.length);
            System.arraycopy(hash, 0, saltAndHash, salt.length, hash.length);

            // Encode the result as Base64
            return Base64.getEncoder().encodeToString(saltAndHash);
        } catch (Exception e) {
            return null;
        }
    }
}