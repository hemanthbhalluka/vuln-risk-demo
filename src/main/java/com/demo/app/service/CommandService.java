package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.regex.Pattern;

@Service
public class CommandService {
    public String checkServerHealth(String ip) {
        StringBuilder output = new StringBuilder();
        try {
            // Validate the IP address using a strict regex pattern
            if (!Pattern.matches("^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$", ip)) {
                throw new IllegalArgumentException("Invalid IP address format.");
            }

            // Use ProcessBuilder to safely construct the command
            ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", ip);
            Process p = pb.start();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                output.append(line);
            }
        } catch (Exception e) {
            output.append("Error: " + e.getMessage());
        }
        return output.toString();
    }
}