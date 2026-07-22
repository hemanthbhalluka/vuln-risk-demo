package com.demo.app.controller;
// VULN: CWE-209 (LOW) - Exception message and full stack trace exposed to the client
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
@ControllerAdvice
public class DebugController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Error: " + e.getMessage() + "\nTrace: " + Arrays.toString(e.getStackTrace()));
    }
}