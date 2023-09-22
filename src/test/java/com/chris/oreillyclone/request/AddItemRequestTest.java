package com.chris.oreillyclone.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddItemRequestTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AddItemRequest#AddItemRequest()}
     *   <li>{@link AddItemRequest#setPrice(double)}
     *   <li>{@link AddItemRequest#setProductId(Long)}
     *   <li>{@link AddItemRequest#setQuantity(int)}
     *   <li>{@link AddItemRequest#setSize(String)}
     *   <li>{@link AddItemRequest#getPrice()}
     *   <li>{@link AddItemRequest#getProductId()}
     *   <li>{@link AddItemRequest#getQuantity()}
     *   <li>{@link AddItemRequest#getSize()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AddItemRequest actualAddItemRequest = new AddItemRequest();
        actualAddItemRequest.setPrice(10.0d);
        actualAddItemRequest.setProductId(1L);
        actualAddItemRequest.setQuantity(1);
        actualAddItemRequest.setSize("Size");
        double actualPrice = actualAddItemRequest.getPrice();
        Long actualProductId = actualAddItemRequest.getProductId();
        int actualQuantity = actualAddItemRequest.getQuantity();
        String actualSize = actualAddItemRequest.getSize();
        assertEquals(10.0d, actualPrice);
        assertEquals(1L, actualProductId.longValue());
        assertEquals(1, actualQuantity);
        assertEquals("Size", actualSize);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AddItemRequest#AddItemRequest(Long, String, int, double)}
     *   <li>{@link AddItemRequest#setPrice(double)}
     *   <li>{@link AddItemRequest#setProductId(Long)}
     *   <li>{@link AddItemRequest#setQuantity(int)}
     *   <li>{@link AddItemRequest#setSize(String)}
     *   <li>{@link AddItemRequest#getPrice()}
     *   <li>{@link AddItemRequest#getProductId()}
     *   <li>{@link AddItemRequest#getQuantity()}
     *   <li>{@link AddItemRequest#getSize()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        AddItemRequest actualAddItemRequest = new AddItemRequest(1L, "Size", 1, 10.0d);
        actualAddItemRequest.setPrice(10.0d);
        actualAddItemRequest.setProductId(1L);
        actualAddItemRequest.setQuantity(1);
        actualAddItemRequest.setSize("Size");
        double actualPrice = actualAddItemRequest.getPrice();
        Long actualProductId = actualAddItemRequest.getProductId();
        int actualQuantity = actualAddItemRequest.getQuantity();
        String actualSize = actualAddItemRequest.getSize();
        assertEquals(10.0d, actualPrice);
        assertEquals(1L, actualProductId.longValue());
        assertEquals(1, actualQuantity);
        assertEquals("Size", actualSize);
    }
}

