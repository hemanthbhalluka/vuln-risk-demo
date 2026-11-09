package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class SQLiUserController {
    private final JdbcTemplate db;

    public SQLiUserController(JdbcTemplate db) {
        this.db = db;
    }

    @GetMapping("/find")
    public List<Map<String, Object>> findUser(@RequestParam String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        return db.query(query, new Object[]{email}, (rs, rowNum) -> {
            Map<String, Object> row = new java.util.HashMap<>();
            row.put("id", rs.getInt("id"));
            row.put("email", rs.getString("email"));
            row.put("name", rs.getString("name"));
            return row;
        });
    }
}