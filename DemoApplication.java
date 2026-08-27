package com.demo.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// ────────────────────────────────────────────────────────────
// [SUGGESTION] DOCSTRINGS_AND_COMMENTS: Added a docstring to describe the purpose of the DemoApplication class and its main method.
@SpringBootApplication
/**
 * The entry point of the Spring Boot application.
 * This class initializes and runs the application.
 */
public class DemoApplication {
    /**
     * Main method to launch the Spring Boot application.
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
// [SUGGESTION END]
// ────────────────────────────────────────────────────────────
