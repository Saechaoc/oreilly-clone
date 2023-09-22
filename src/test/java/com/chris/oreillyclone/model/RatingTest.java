package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class RatingTest {
    /**
     * Method under test: {@link Rating#Rating()}
     */
    @Test
    void testConstructor() {
        Rating actualRating = new Rating();
        assertNull(actualRating.getCreatedAt());
        assertNull(actualRating.getUser());
        assertEquals(0.0d, actualRating.getRating());
        assertNull(actualRating.getProduct());
        assertNull(actualRating.getId());
    }

    /**
     * Method under test: {@link Rating#Rating(Long, User, Product, double, LocalDateTime)}
     */
    @Test
    void testConstructor2() {
        User user = mock(User.class);
        Product product = mock(Product.class);
        Rating actualRating = new Rating(1L, user, product, 10.0d, LocalDate.of(1970, 1, 1).atStartOfDay());

        assertSame(user, actualRating.getUser());
        assertEquals("00:00", actualRating.getCreatedAt().toLocalTime().toString());
        assertEquals(10.0d, actualRating.getRating());
        assertSame(product, actualRating.getProduct());
        assertEquals(1L, actualRating.getId().longValue());
    }
}

