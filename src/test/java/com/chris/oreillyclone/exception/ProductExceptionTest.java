package com.chris.oreillyclone.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ProductExceptionTest {
    /**
     * Method under test: {@link ProductException#ProductException(String)}
     */
    @Test
    void testConstructor() {
        ProductException actualProductException = new ProductException("An error occurred");
        assertNull(actualProductException.getCause());
        assertEquals(0, actualProductException.getSuppressed().length);
        assertEquals("An error occurred", actualProductException.getMessage());
        assertEquals("An error occurred", actualProductException.getLocalizedMessage());
    }
}

