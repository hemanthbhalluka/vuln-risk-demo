package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.regex.Pattern;

@Service
public class CommandService {
    private static final Pattern IP_ADDRESS_PATTERN = 
        Pattern.compile("^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$");

    public String checkServerHealth(String ip) {
        StringBuilder output = new StringBuilder();
        if (!isValidIpAddress(ip)) {
            throw new IllegalArgumentException("Invalid IP address format");
        }
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("ping", "-c", "3", ip);
            Process process = processBuilder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                output.append(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error executing ping command", e);
        }
        return output.toString();
    }

    private boolean isValidIpAddress(String ip) {
        return IP_ADDRESS_PATTERN.matcher(ip).matches();
    }
}