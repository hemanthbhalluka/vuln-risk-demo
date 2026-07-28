package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/proxy")
public class ProxyController {

    private static final Pattern ALLOWED_HOSTS = Pattern.compile("^(https?://(www\.)?example\.com(/.*)?)$");

    @GetMapping("/fetch")
    public String fetchResource(@RequestParam String targetUrl) {
        StringBuilder result = new StringBuilder();
        try {
            if (!ALLOWED_HOSTS.matcher(targetUrl).matches()) {
                throw new IllegalArgumentException("URL is not allowed.");
            }

            URL url = new URL(targetUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
            }
        } catch (Exception e) {
            return "Error fetching resource: " + e.getMessage();
        }
        return result.toString();
    }
}