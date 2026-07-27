package com.demo.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class SQLiUserController {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SQLiUserController(JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @GetMapping("/find")
    public List<Map<String, Object>> findUser(@RequestParam String email) {
        String query = "SELECT * FROM users WHERE email = :email";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("email", email);
        return namedParameterJdbcTemplate.queryForList(query, parameters);
    }
}