package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "https://trusteddomain.com", allowedHeaders = "Content-Type, Authorization")
public class CorsController {
    @GetMapping("/data")
    public String getData() {
        return "Public Data";
    }
}