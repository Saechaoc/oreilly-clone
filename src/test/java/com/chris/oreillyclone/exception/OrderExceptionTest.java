package com.chris.oreillyclone.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class OrderExceptionTest {
    /**
     * Method under test: {@link OrderException#OrderException(String)}
     */
    @Test
    void testConstructor() {
        OrderException actualOrderException = new OrderException("An error occurred");
        assertNull(actualOrderException.getCause());
        assertEquals(0, actualOrderException.getSuppressed().length);
        assertEquals("An error occurred", actualOrderException.getMessage());
        assertEquals("An error occurred", actualOrderException.getLocalizedMessage());
    }
}

