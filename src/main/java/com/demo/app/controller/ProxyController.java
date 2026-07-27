package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/proxy")
public class ProxyController {

    private static final Set<String> ALLOWED_HOSTS = new HashSet<>();

    static {
        ALLOWED_HOSTS.add("example.com");
        ALLOWED_HOSTS.add("api.example.com");
    }

    @GetMapping("/fetch")
    public String fetchResource(@RequestParam String targetUrl) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(targetUrl);

            // Validate URL scheme
            String protocol = url.getProtocol();
            if (!"http".equalsIgnoreCase(protocol) && !"https".equalsIgnoreCase(protocol)) {
                throw new IllegalArgumentException("Invalid URL scheme");
            }

            // Resolve host and validate against allowlist
            String host = url.getHost();
            InetAddress address = InetAddress.getByName(host);
            if (!ALLOWED_HOSTS.contains(host) || address.isAnyLocalAddress() || address.isLoopbackAddress() || address.isSiteLocalAddress()) {
                throw new IllegalArgumentException("Host is not allowed");
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