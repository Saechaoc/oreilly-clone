package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class OrderItemTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link OrderItem#OrderItem()}
     *   <li>{@link OrderItem#setDeliveryDate(LocalDateTime)}
     *   <li>{@link OrderItem#setId(Long)}
     *   <li>{@link OrderItem#setOrder(Order)}
     *   <li>{@link OrderItem#setPrice(double)}
     *   <li>{@link OrderItem#setProduct(Product)}
     *   <li>{@link OrderItem#setQuantity(int)}
     *   <li>{@link OrderItem#setSize(String)}
     *   <li>{@link OrderItem#setUserId(Long)}
     *   <li>{@link OrderItem#getDeliveryDate()}
     *   <li>{@link OrderItem#getId()}
     *   <li>{@link OrderItem#getOrder()}
     *   <li>{@link OrderItem#getPrice()}
     *   <li>{@link OrderItem#getProduct()}
     *   <li>{@link OrderItem#getQuantity()}
     *   <li>{@link OrderItem#getSize()}
     *   <li>{@link OrderItem#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        OrderItem actualOrderItem = new OrderItem();
        LocalDateTime deliveryDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualOrderItem.setDeliveryDate(deliveryDate);
        actualOrderItem.setId(1L);
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
        Address shippingAddress = new Address();
        shippingAddress.setCity("Oxford");
        shippingAddress.setFirstName("Jane");
        shippingAddress.setId(1L);
        shippingAddress.setLastName("Doe");
        shippingAddress.setMobile("Mobile");
        shippingAddress.setState("MD");
        shippingAddress.setStreetAddress("42 Main St");
        shippingAddress.setUser(user);
        shippingAddress.setZipCode("21654");
        User user2 = new User();
        user2.setAddressList(new ArrayList<>());
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setMobile("Mobile");
        user2.setPassword("iloveyou");
        user2.setPaymentInformationList(new ArrayList<>());
        user2.setRatingList(new ArrayList<>());
        user2.setReviewList(new ArrayList<>());
        user2.setRole("Role");
        Order order = new Order();
        order.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        order.setDeliveryDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        order.setId(1L);
        order.setNumItems(1000);
        order.setOrderDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        order.setOrderId("42");
        order.setOrderItemList(new ArrayList<>());
        order.setOrderStatus("Order Status");
        order.setPaymentDetails(new PaymentDetails());
        order.setShippingAddress(shippingAddress);
        order.setTotalPrice(10.0d);
        order.setUser(user2);
        actualOrderItem.setOrder(order);
        actualOrderItem.setPrice(10.0d);
        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());
        Category parentCategory2 = new Category();
        parentCategory2.setId(1L);
        parentCategory2.setLevel(1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);
        Category category = new Category();
        category.setId(1L);
        category.setLevel(1);
        category.setName("Name");
        category.setParentCategory(parentCategory2);
        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImageUrl("https://example.org/example");
        product.setNumRatings(10);
        product.setPrice(10.0d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(1);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Dr");
        actualOrderItem.setProduct(product);
        actualOrderItem.setQuantity(1);
        actualOrderItem.setSize("Size");
        actualOrderItem.setUserId(1L);
        LocalDateTime actualDeliveryDate = actualOrderItem.getDeliveryDate();
        Long actualId = actualOrderItem.getId();
        Order actualOrder = actualOrderItem.getOrder();
        double actualPrice = actualOrderItem.getPrice();
        Product actualProduct = actualOrderItem.getProduct();
        int actualQuantity = actualOrderItem.getQuantity();
        String actualSize = actualOrderItem.getSize();
        Long actualUserId = actualOrderItem.getUserId();
        assertSame(deliveryDate, actualDeliveryDate);
        assertEquals(1L, actualId.longValue());
        assertSame(order, actualOrder);
        assertEquals(10.0d, actualPrice);
        assertSame(product, actualProduct);
        assertEquals(1, actualQuantity);
        assertEquals("Size", actualSize);
        assertEquals(1L, actualUserId.longValue());
    }

    /**
     * Method under test: {@link OrderItem#OrderItem(Long, Order, Product, String, int, double, Long, LocalDateTime)}
     */
    @Test
    void testConstructor2() {
        Order order = mock(Order.class);
        Product product = mock(Product.class);
        OrderItem actualOrderItem = new OrderItem(1L, order, product, "Size", 1, 10.0d, 1L,
                LocalDate.of(1970, 1, 1).atStartOfDay());

        assertEquals(1L, actualOrderItem.getUserId().longValue());
        assertEquals("00:00", actualOrderItem.getDeliveryDate().toLocalTime().toString());
        assertEquals("Size", actualOrderItem.getSize());
        assertEquals(1, actualOrderItem.getQuantity());
        assertSame(product, actualOrderItem.getProduct());
        assertEquals(10.0d, actualOrderItem.getPrice());
        assertSame(order, actualOrderItem.getOrder());
        assertEquals(1L, actualOrderItem.getId().longValue());
    }
}

