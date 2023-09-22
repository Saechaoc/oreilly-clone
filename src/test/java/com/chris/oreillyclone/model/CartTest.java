package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class CartTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Cart#setCartItems(Set)}
     *   <li>{@link Cart#setId(Long)}
     *   <li>{@link Cart#setTotalItems(int)}
     *   <li>{@link Cart#setTotalPrice(double)}
     *   <li>{@link Cart#setUser(User)}
     *   <li>{@link Cart#getCartItems()}
     *   <li>{@link Cart#getId()}
     *   <li>{@link Cart#getTotalItems()}
     *   <li>{@link Cart#getTotalPrice()}
     *   <li>{@link Cart#getUser()}
     * </ul>
     */
    @Test
    void testSetCartItems() {
        Cart cart = new Cart();
        HashSet<CartItem> cartItems = new HashSet<>();
        cart.setCartItems(cartItems);
        cart.setId(1L);
        cart.setTotalItems(1000);
        cart.setTotalPrice(10.0d);
        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setMobile("Mobile");
        user.setPassword("iloveyou");
        user.setPaymentInformationList(new ArrayList<>());
        user.setRatingList(new ArrayList<>());
        user.setReviewList(new ArrayList<>());
        user.setRole("Role");
        cart.setUser(user);
        Set<CartItem> actualCartItems = cart.getCartItems();
        Long actualId = cart.getId();
        int actualTotalItems = cart.getTotalItems();
        double actualTotalPrice = cart.getTotalPrice();
        User actualUser = cart.getUser();
        assertSame(cartItems, actualCartItems);
        assertEquals(1L, actualId.longValue());
        assertEquals(1000, actualTotalItems);
        assertEquals(10.0d, actualTotalPrice);
        assertSame(user, actualUser);
    }
}

