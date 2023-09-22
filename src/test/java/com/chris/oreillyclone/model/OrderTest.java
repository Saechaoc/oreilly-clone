package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class OrderTest {
    /**
     * Method under test: {@link Order#Order()}
     */
    @Test
    void testConstructor() {
        assertTrue((new Order()).getOrderItemList().isEmpty());
    }

    /**
     * Method under test: {@link Order#Order(Long, String, User, List, LocalDateTime, LocalDateTime, Address, PaymentDetails, double, String, int, LocalDateTime)}
     */
    @Test
    void testConstructor2() {
        User user = new User();
        ArrayList<Address> addressList = new ArrayList<>();
        user.setAddressList(addressList);
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
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        LocalDateTime orderDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        LocalDateTime deliveryDate = LocalDate.of(1970, 1, 1).atStartOfDay();

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

        Address shippingAddress = new Address();
        shippingAddress.setCity("Oxford");
        shippingAddress.setFirstName("Jane");
        shippingAddress.setId(1L);
        shippingAddress.setLastName("Doe");
        shippingAddress.setMobile("Mobile");
        shippingAddress.setState("MD");
        shippingAddress.setStreetAddress("42 Main St");
        shippingAddress.setUser(user2);
        shippingAddress.setZipCode("21654");
        PaymentDetails paymentDetails = new PaymentDetails();
        Order actualOrder = new Order(1L, "42", user, orderItemList, orderDate, deliveryDate, shippingAddress,
                paymentDetails, 10.0d, "Order Status", 1000, LocalDate.of(1970, 1, 1).atStartOfDay());

        assertSame(user, actualOrder.getUser());
        assertEquals("00:00", actualOrder.getCreatedAt().toLocalTime().toString());
        assertEquals(1000, actualOrder.getNumItems());
        assertEquals("00:00", actualOrder.getDeliveryDate().toLocalTime().toString());
        assertEquals("Order Status", actualOrder.getOrderStatus());
        assertSame(paymentDetails, actualOrder.getPaymentDetails());
        assertSame(shippingAddress, actualOrder.getShippingAddress());
        assertEquals(10.0d, actualOrder.getTotalPrice());
        assertEquals(1L, actualOrder.getId().longValue());
        assertEquals("42", actualOrder.getOrderId());
        assertEquals("1970-01-01", actualOrder.getOrderDate().toLocalDate().toString());
        assertEquals(addressList, actualOrder.getOrderItemList());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Order#setCreatedAt(LocalDateTime)}
     *   <li>{@link Order#setDeliveryDate(LocalDateTime)}
     *   <li>{@link Order#setId(Long)}
     *   <li>{@link Order#setNumItems(int)}
     *   <li>{@link Order#setOrderDate(LocalDateTime)}
     *   <li>{@link Order#setOrderId(String)}
     *   <li>{@link Order#setOrderItemList(List)}
     *   <li>{@link Order#setOrderStatus(String)}
     *   <li>{@link Order#setPaymentDetails(PaymentDetails)}
     *   <li>{@link Order#setShippingAddress(Address)}
     *   <li>{@link Order#setTotalPrice(double)}
     *   <li>{@link Order#setUser(User)}
     *   <li>{@link Order#getCreatedAt()}
     *   <li>{@link Order#getDeliveryDate()}
     *   <li>{@link Order#getId()}
     *   <li>{@link Order#getNumItems()}
     *   <li>{@link Order#getOrderDate()}
     *   <li>{@link Order#getOrderId()}
     *   <li>{@link Order#getOrderItemList()}
     *   <li>{@link Order#getOrderStatus()}
     *   <li>{@link Order#getPaymentDetails()}
     *   <li>{@link Order#getShippingAddress()}
     *   <li>{@link Order#getTotalPrice()}
     *   <li>{@link Order#getUser()}
     * </ul>
     */
    @Test
    void testSetCreatedAt() {
        Order order = new Order();
        LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setCreatedAt(createdAt);
        LocalDateTime deliveryDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDeliveryDate(deliveryDate);
        order.setId(1L);
        order.setNumItems(1000);
        LocalDateTime orderDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setOrderDate(orderDate);
        order.setOrderId("42");
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        order.setOrderItemList(orderItemList);
        order.setOrderStatus("Order Status");
        PaymentDetails paymentDetails = new PaymentDetails();
        order.setPaymentDetails(paymentDetails);
        User user = new User();
        ArrayList<Address> addressList = new ArrayList<>();
        user.setAddressList(addressList);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setMobile("Mobile");
        user.setPassword("iloveyou");
        ArrayList<PaymentInformation> paymentInformationList = new ArrayList<>();
        user.setPaymentInformationList(paymentInformationList);
        ArrayList<Rating> ratingList = new ArrayList<>();
        user.setRatingList(ratingList);
        ArrayList<Review> reviewList = new ArrayList<>();
        user.setReviewList(reviewList);
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
        order.setShippingAddress(shippingAddress);
        order.setTotalPrice(10.0d);
        User user2 = new User();
        ArrayList<Address> addressList2 = new ArrayList<>();
        user2.setAddressList(addressList2);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setMobile("Mobile");
        user2.setPassword("iloveyou");
        ArrayList<PaymentInformation> paymentInformationList2 = new ArrayList<>();
        user2.setPaymentInformationList(paymentInformationList2);
        ArrayList<Rating> ratingList2 = new ArrayList<>();
        user2.setRatingList(ratingList2);
        ArrayList<Review> reviewList2 = new ArrayList<>();
        user2.setReviewList(reviewList2);
        user2.setRole("Role");
        order.setUser(user2);
        LocalDateTime actualCreatedAt = order.getCreatedAt();
        LocalDateTime actualDeliveryDate = order.getDeliveryDate();
        Long actualId = order.getId();
        int actualNumItems = order.getNumItems();
        LocalDateTime actualOrderDate = order.getOrderDate();
        String actualOrderId = order.getOrderId();
        List<OrderItem> actualOrderItemList = order.getOrderItemList();
        String actualOrderStatus = order.getOrderStatus();
        PaymentDetails actualPaymentDetails = order.getPaymentDetails();
        Address actualShippingAddress = order.getShippingAddress();
        double actualTotalPrice = order.getTotalPrice();
        User actualUser = order.getUser();
        assertSame(createdAt, actualCreatedAt);
        assertSame(deliveryDate, actualDeliveryDate);
        assertEquals(1L, actualId.longValue());
        assertEquals(1000, actualNumItems);
        assertSame(orderDate, actualOrderDate);
        assertEquals("42", actualOrderId);
        assertSame(orderItemList, actualOrderItemList);
        assertEquals(addressList, actualOrderItemList);
        assertEquals(paymentInformationList, actualOrderItemList);
        assertEquals(ratingList, actualOrderItemList);
        assertEquals(reviewList, actualOrderItemList);
        assertEquals(addressList2, actualOrderItemList);
        assertEquals(paymentInformationList2, actualOrderItemList);
        assertEquals(ratingList2, actualOrderItemList);
        assertEquals(reviewList2, actualOrderItemList);
        assertEquals("Order Status", actualOrderStatus);
        assertSame(paymentDetails, actualPaymentDetails);
        assertSame(shippingAddress, actualShippingAddress);
        assertEquals(10.0d, actualTotalPrice);
        assertSame(user2, actualUser);
    }
}

