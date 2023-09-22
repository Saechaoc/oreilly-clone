package com.chris.oreillyclone.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuthResponseTest {
    /**
     * Method under test: {@link AuthResponse#AuthResponse(String, String)}
     */
    @Test
    void testConstructor() {
        AuthResponse actualAuthResponse = new AuthResponse("Jwt", "Not all who wander are lost");

        assertEquals("Jwt", actualAuthResponse.getJwt());
        assertEquals("Not all who wander are lost", actualAuthResponse.getMessage());
    }
}

