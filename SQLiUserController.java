package com.demo.app.controller;
// VULN: CWE-89 (HIGH) - SQL Injection via string-concatenated query
// ────────────────────────────────────────────────────────────
// [REFACTOR] STANDARD_VIOLATION (HIGH): Wildcard imports are used in the import statement, which violates the standard.
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// [REFACTOR END]
// ────────────────────────────────────────────────────────────
// [REFACTOR] QUALITY (HIGH): The import statement uses a wildcard ('*'), which is against best practices as it can lead to unnece
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// [REFACTOR END]
// ────────────────────────────────────────────────────────────
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
@RestController @RequestMapping("/api/users")
// ────────────────────────────────────────────────────────────
// [REFACTOR] RECOMMENDATION (LOW): Consider renaming the class SQLiUserController to follow PascalCase naming conventions, such as Sqli
// ────────────────────────────────────────────────────────────
// [SUGGESTION] DOCSTRINGS_AND_COMMENTS: Added a class-level docstring to describe the purpose of the SqliUserController class.
/**
 * Controller for handling user-related API requests.
 * Provides endpoints for retrieving user information.
 */
public class SqliUserController {
// [SUGGESTION END]
// ────────────────────────────────────────────────────────────
// [REFACTOR END]
// ────────────────────────────────────────────────────────────
    private final JdbcTemplate db;
    // ────────────────────────────────────────────────────────────
    // [SUGGESTION] DOCSTRINGS_AND_COMMENTS: Added a constructor-level docstring to describe the purpose of the SQLiUserController constructor.
    /**
     * Constructs the SqliUserController with the provided JdbcTemplate.
     *
     * @param db the JdbcTemplate used for database operations
     */
    public SQLiUserController(JdbcTemplate db) { this.db = db; }
    // [SUGGESTION END]
    // ────────────────────────────────────────────────────────────
    @GetMapping("/find")
    // ────────────────────────────────────────────────────────────
    // [REFACTOR] SECURITY (HIGH): The method 'findUser' constructs an SQL query using string concatenation with user input, which is v
        // ────────────────────────────────────────────────────────────
        // [SUGGESTION] DOCSTRINGS_AND_COMMENTS: Added a method-level docstring to describe the purpose and parameters of the findUser method.
        /**
         * Finds and retrieves user information based on the provided email.
         *
         * @param email the email address of the user to find
         * @return a list of maps containing user information
         */
        public List<Map<String, Object>> findUser(@RequestParam String email) {
        // [SUGGESTION END]
        // ────────────────────────────────────────────────────────────
            return db.queryForList("SELECT * FROM users WHERE email = ?", email);
    // [REFACTOR END]
    // ────────────────────────────────────────────────────────────
    }
}