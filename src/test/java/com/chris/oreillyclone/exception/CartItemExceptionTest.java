package com.chris.oreillyclone.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CartItemExceptionTest {
    /**
     * Method under test: {@link CartItemException#CartItemException(String)}
     */
    @Test
    void testConstructor() {
        CartItemException actualCartItemException = new CartItemException("An error occurred");
        assertNull(actualCartItemException.getCause());
        assertEquals(0, actualCartItemException.getSuppressed().length);
        assertEquals("An error occurred", actualCartItemException.getMessage());
        assertEquals("An error occurred", actualCartItemException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link CartItemException#CartItemException(String, Throwable)}
     */
    @Test
    void testConstructor2() {
        Throwable cause = new Throwable();
        CartItemException actualCartItemException = new CartItemException("An error occurred", cause);

        Throwable cause2 = actualCartItemException.getCause();
        assertSame(cause, cause2);
        Throwable[] suppressed = actualCartItemException.getSuppressed();
        assertEquals(0, suppressed.length);
        assertEquals("An error occurred", actualCartItemException.getLocalizedMessage());
        assertEquals("An error occurred", actualCartItemException.getMessage());
        assertNull(cause2.getLocalizedMessage());
        assertNull(cause2.getCause());
        assertNull(cause2.getMessage());
        assertSame(suppressed, cause2.getSuppressed());
    }

    /**
     * Method under test: {@link CartItemException#CartItemException(String, Throwable, boolean, boolean)}
     */
    @Test
    void testConstructor3() {
        Throwable cause = new Throwable();
        CartItemException actualCartItemException = new CartItemException("An error occurred", cause, true, true);

        Throwable cause2 = actualCartItemException.getCause();
        assertSame(cause, cause2);
        Throwable[] suppressed = actualCartItemException.getSuppressed();
        assertEquals(0, suppressed.length);
        assertEquals("An error occurred", actualCartItemException.getLocalizedMessage());
        assertEquals("An error occurred", actualCartItemException.getMessage());
        assertNull(cause2.getLocalizedMessage());
        assertNull(cause2.getCause());
        assertNull(cause2.getMessage());
        assertSame(suppressed, cause2.getSuppressed());
    }

    /**
     * Method under test: {@link CartItemException#CartItemException(Throwable)}
     */
    @Test
    void testConstructor4() {
        Throwable cause = new Throwable();
        CartItemException actualCartItemException = new CartItemException(cause);
        Throwable cause2 = actualCartItemException.getCause();
        assertSame(cause, cause2);
        Throwable[] suppressed = actualCartItemException.getSuppressed();
        assertEquals(0, suppressed.length);
        assertEquals("java.lang.Throwable", actualCartItemException.getLocalizedMessage());
        assertEquals("java.lang.Throwable", actualCartItemException.getMessage());
        assertNull(cause2.getLocalizedMessage());
        assertNull(cause2.getCause());
        assertNull(cause2.getMessage());
        assertSame(suppressed, cause2.getSuppressed());
    }
}

