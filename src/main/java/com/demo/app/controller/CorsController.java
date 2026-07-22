package com.demo.app.controller;
// VULN: CWE-942 (LOW) - Overly permissive CORS policy (wildcard origin + headers)
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorsController {
    @GetMapping("/data")
    public String getData() {
        return "Public Data";
    }
}