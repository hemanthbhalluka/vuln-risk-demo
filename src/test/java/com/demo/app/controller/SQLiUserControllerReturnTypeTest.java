package com.demo.app.controller;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SQLiUserControllerReturnTypeTest {

    @Test
    public void testFindUserReturnType() throws NoSuchMethodException {
        // Get the method using reflection
        Method method = SQLiUserController.class.getDeclaredMethod("findUser", String.class);

        // Assert that the return type matches the original declaration
        assertEquals(List.class, method.getReturnType(), "Return type of findUser method should be List");
    }
}