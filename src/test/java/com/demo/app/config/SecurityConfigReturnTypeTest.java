package com.demo.app.config;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecurityConfigReturnTypeTest {

    @Test
    public void testFilterChainReturnType() throws NoSuchMethodException {
        // Get the SecurityConfig class
        Class<?> clazz = SecurityConfig.class;

        // Get the filterChain method with its parameter type
        Method method = clazz.getDeclaredMethod("filterChain", org.springframework.security.config.annotation.web.builders.HttpSecurity.class);

        // Assert that the return type is SecurityFilterChain
        assertEquals(org.springframework.security.web.SecurityFilterChain.class, method.getReturnType(), "The return type of filterChain method should be SecurityFilterChain");
    }
}