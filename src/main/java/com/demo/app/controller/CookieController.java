package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class CookieController {

    @GetMapping("/login")
    public String login(HttpServletResponse response) {
        Cookie cookie = new Cookie("SESSION_TOKEN", "abc123xyz");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);
        return "Logged in";
    }
}