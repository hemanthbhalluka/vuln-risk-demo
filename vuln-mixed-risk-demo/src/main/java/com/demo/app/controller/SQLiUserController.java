package com.demo.app.controller;
// VULN: CWE-89 (HIGH) - SQL Injection via string-concatenated query
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
@RestController @RequestMapping("/api/users")
public class SQLiUserController {
    private final JdbcTemplate db;
    public SQLiUserController(JdbcTemplate db) { this.db = db; }
    @GetMapping("/find")
    public List<Map<String, Object>> findUser(@RequestParam String email) {
        return db.queryForList("SELECT * FROM users WHERE email = '" + email + "'");
    }
}