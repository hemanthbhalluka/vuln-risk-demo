package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import java.net.*;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/api/proxy")
public class ProxyController {

    private static final Set<String> ALLOWED_HOSTS = Set.of("example.com", "api.example.com");

    @GetMapping("/fetch")
    public String fetchResource(@RequestParam String targetUrl) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(targetUrl);

            // Validate URL scheme
            if (!"http".equalsIgnoreCase(url.getProtocol()) && !"https".equalsIgnoreCase(url.getProtocol())) {
                throw new IllegalArgumentException("Invalid URL scheme");
            }

            // Resolve hostname and validate against allow-list
            InetAddress address = InetAddress.getByName(url.getHost());
            if (address.isAnyLocalAddress() || address.isLoopbackAddress() || address.isSiteLocalAddress()) {
                throw new IllegalArgumentException("Access to private or loopback addresses is not allowed");
            }

            if (!ALLOWED_HOSTS.contains(url.getHost())) {
                throw new IllegalArgumentException("Host is not in the allow-list");
            }

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return result.toString();
    }
}