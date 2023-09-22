package com.chris.oreillyclone.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LoginRequestTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#LoginRequest()}
     *   <li>{@link LoginRequest#setEmail(String)}
     *   <li>{@link LoginRequest#setPassword(String)}
     *   <li>{@link LoginRequest#getEmail()}
     *   <li>{@link LoginRequest#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        LoginRequest actualLoginRequest = new LoginRequest();
        actualLoginRequest.setEmail("jane.doe@example.org");
        actualLoginRequest.setPassword("iloveyou");
        String actualEmail = actualLoginRequest.getEmail();
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("iloveyou", actualLoginRequest.getPassword());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#LoginRequest(String, String)}
     *   <li>{@link LoginRequest#setEmail(String)}
     *   <li>{@link LoginRequest#setPassword(String)}
     *   <li>{@link LoginRequest#getEmail()}
     *   <li>{@link LoginRequest#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LoginRequest actualLoginRequest = new LoginRequest("jane.doe@example.org", "iloveyou");
        actualLoginRequest.setEmail("jane.doe@example.org");
        actualLoginRequest.setPassword("iloveyou");
        String actualEmail = actualLoginRequest.getEmail();
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("iloveyou", actualLoginRequest.getPassword());
    }
}

