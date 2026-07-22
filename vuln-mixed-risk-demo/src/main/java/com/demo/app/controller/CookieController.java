package com.demo.app.controller;
// VULN: CWE-614 (LOW) - Session cookie issued without Secure/HttpOnly flags
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
@RestController @RequestMapping("/api/auth")
public class CookieController {
    @GetMapping("/login")
    public String login(HttpServletResponse response) {
        Cookie cookie = new Cookie("SESSION_TOKEN", "abc123xyz");
        cookie.setHttpOnly(false);
        cookie.setSecure(false);
        response.addCookie(cookie);
        return "Logged in";
    }
}