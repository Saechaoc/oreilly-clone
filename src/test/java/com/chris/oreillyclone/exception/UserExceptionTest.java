package com.chris.oreillyclone.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class UserExceptionTest {
    /**
     * Method under test: {@link UserException#UserException(String)}
     */
    @Test
    void testConstructor() {
        UserException actualUserException = new UserException("An error occurred");
        assertNull(actualUserException.getCause());
        assertEquals(0, actualUserException.getSuppressed().length);
        assertEquals("An error occurred", actualUserException.getMessage());
        assertEquals("An error occurred", actualUserException.getLocalizedMessage());
    }
}

