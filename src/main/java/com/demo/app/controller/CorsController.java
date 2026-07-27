package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "https://trusteddomain.com", allowedHeaders = "Content-Type, Authorization")
public class CorsController {
    @GetMapping("/data")
    public String getData() {
        return "Public Data";
    }
}