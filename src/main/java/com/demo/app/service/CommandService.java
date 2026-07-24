package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;
import java.net.InetAddress;

@Service
public class CommandService {
    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile(
        "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$"
    );

    public String checkServerHealth(String ip) {
        StringBuilder output = new StringBuilder();
        if (!isValidIpAddress(ip)) {
            throw new IllegalArgumentException("Invalid IP address format");
        }

        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            if (!inetAddress.isReachable(3000)) {
                throw new RuntimeException("Host is not reachable");
            }
            output.append("Ping successful to IP: ").append(ip);
        } catch (Exception e) {
            throw new RuntimeException("Error checking server health", e);
        }

        return output.toString();
    }

    private boolean isValidIpAddress(String ip) {
        return IP_ADDRESS_PATTERN.matcher(ip).matches();
    }
}