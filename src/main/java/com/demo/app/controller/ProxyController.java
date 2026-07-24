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
import java.net.URI;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/proxy")
public class ProxyController {

    private static final Set<String> ALLOWED_HOSTS = new HashSet<>();
    private static final Pattern IP_PRIVATE_PATTERN = Pattern.compile(
        "^(127\\.|10\\.|192\\.168\\.|172\\.(1[6-9]|2[0-9]|3[0-1])\\.|169\\.254\\.|::1|fc..:|fd..:|fe80:|::ffff:127\\.|::ffff:10\\.|::ffff:192\\.168\\.|::ffff:172\\.(1[6-9]|2[0-9]|3[0-1])\\.|::ffff:169\\.254\\.)"
    );

    static {
        ALLOWED_HOSTS.add("example.com");
        ALLOWED_HOSTS.add("api.example.com");
    }

    @GetMapping("/fetch")
    public String fetchResource(@RequestParam String targetUrl) {
        StringBuilder result = new StringBuilder();
        try {
            URI uri = new URI(targetUrl);

            // Validate scheme
            String scheme = uri.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                throw new IllegalArgumentException("Invalid URL scheme");
            }

            // Validate host
            String host = uri.getHost();
            if (host == null || !ALLOWED_HOSTS.contains(host)) {
                throw new IllegalArgumentException("Host not allowed");
            }

            // Validate IP address after DNS resolution
            InetAddress address = InetAddress.getByName(host);
            String ipAddress = address.getHostAddress();
            if (IP_PRIVATE_PATTERN.matcher(ipAddress).find() || address.isLoopbackAddress() || address.isSiteLocalAddress() || address.isLinkLocalAddress()) {
                throw new IllegalArgumentException("Invalid IP address");
            }

            URL url = uri.toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000); // Set a timeout to prevent hanging requests
            conn.setReadTimeout(5000);

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