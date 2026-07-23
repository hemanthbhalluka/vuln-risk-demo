package com.demo.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class DebugController {

    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Log the exception details for debugging purposes
        logger.error("An unexpected error occurred", e);

        // Return a generic error message to the client
        return ResponseEntity.status(500).body("An unexpected error occurred. Please contact support if the issue persists.");
    }
}