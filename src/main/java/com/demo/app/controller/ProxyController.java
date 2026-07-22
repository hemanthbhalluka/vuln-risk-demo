package com.demo.app.controller;
// VULN: CWE-918 (HIGH) - Server-Side Request Forgery: fetches any caller-supplied URL
import org.springframework.web.bind.annotation.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@RestController @RequestMapping("/api/proxy")
public class ProxyController {
    @GetMapping("/fetch")
    public String fetchResource(@RequestParam String targetUrl) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(targetUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) { result.append(line); }
        } catch (Exception e) {}
        return result.toString();
    }
}