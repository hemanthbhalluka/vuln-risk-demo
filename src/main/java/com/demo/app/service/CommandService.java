package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.InetAddress;
import java.util.regex.Pattern;

@Service
public class CommandService {

    private static final Pattern IPV4_PATTERN = Pattern.compile(
        "^(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$");

    public String checkServerHealth(String ip) {
        if (!isValidIp(ip)) {
            throw new IllegalArgumentException("Invalid IP address format");
        }

        try {
            InetAddress inet = InetAddress.getByName(ip);
            boolean isReachable = inet.isReachable(3000); // Timeout of 3 seconds
            return isReachable ? "Server is reachable" : "Server is not reachable";
        } catch (IOException e) {
            // Log the exception (not shown here for brevity)
            throw new RuntimeException("Error checking server health", e);
        }
    }

    private boolean isValidIp(String ip) {
        return IPV4_PATTERN.matcher(ip).matches();
    }
}