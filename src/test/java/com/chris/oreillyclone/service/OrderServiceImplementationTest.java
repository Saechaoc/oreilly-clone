package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.OrderException;
import com.chris.oreillyclone.model.*;
import com.chris.oreillyclone.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {OrderServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class OrderServiceImplementationTest {
    @MockBean
    private CartItemService cartItemService;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private OrderServiceImplementation orderServiceImplementation;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link OrderServiceImplementation#createOrder(User, Address)}
     */
    @Test
    void testCreateOrder() {
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
        assertNull(orderServiceImplementation.createOrder(user, shippingAddress));
    }

    /**
     * Method under test: {@link OrderServiceImplementation#createOrder(User, Address)}
     */
    @Test
    void testCreateOrder2() {
        User user = mock(User.class);
        doNothing().when(user).setAddressList(Mockito.<List<Address>>any());
        doNothing().when(user).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(user).setEmail(Mockito.<String>any());
        doNothing().when(user).setFirstName(Mockito.<String>any());
        doNothing().when(user).setId(Mockito.<Long>any());
        doNothing().when(user).setLastName(Mockito.<String>any());
        doNothing().when(user).setMobile(Mockito.<String>any());
        doNothing().when(user).setPassword(Mockito.<String>any());
        doNothing().when(user).setPaymentInformationList(Mockito.<List<PaymentInformation>>any());
        doNothing().when(user).setRatingList(Mockito.<List<Rating>>any());
        doNothing().when(user).setReviewList(Mockito.<List<Review>>any());
        doNothing().when(user).setRole(Mockito.<String>any());
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
        assertNull(orderServiceImplementation.createOrder(user, shippingAddress));
        verify(user).setAddressList(Mockito.<List<Address>>any());
        verify(user).setCreatedAt(Mockito.<LocalDateTime>any());
        verify(user).setEmail(Mockito.<String>any());
        verify(user).setFirstName(Mockito.<String>any());
        verify(user).setId(Mockito.<Long>any());
        verify(user).setLastName(Mockito.<String>any());
        verify(user).setMobile(Mockito.<String>any());
        verify(user).setPassword(Mockito.<String>any());
        verify(user).setPaymentInformationList(Mockito.<List<PaymentInformation>>any());
        verify(user).setRatingList(Mockito.<List<Rating>>any());
        verify(user).setReviewList(Mockito.<List<Review>>any());
        verify(user).setRole(Mockito.<String>any());
    }

    /**
     * Method under test: {@link OrderServiceImplementation#userOrderHistory(Long)}
     */
    @Test
    void testUserOrderHistory() {
        assertNull(orderServiceImplementation.userOrderHistory(1L));
    }

    /**
     * Method under test: {@link OrderServiceImplementation#placedOrder(Long)}
     */
    @Test
    void testPlacedOrder() throws OrderException {
        assertNull(orderServiceImplementation.placedOrder(1L));
    }

    /**
     * Method under test: {@link OrderServiceImplementation#confirmedOrder(Long)}
     */
    @Test
    void testConfirmedOrder() throws OrderException {
        assertNull(orderServiceImplementation.confirmedOrder(1L));
    }

    /**
     * Method under test: {@link OrderServiceImplementation#shippedOrder(Long)}
     */
    @Test
    void testShippedOrder() throws OrderException {
        assertNull(orderServiceImplementation.shippedOrder(1L));
    }

    /**
     * Method under test: {@link OrderServiceImplementation#deliveredOrder(Long)}
     */
    @Test
    void testDeliveredOrder() throws OrderException {
        assertNull(orderServiceImplementation.deliveredOrder(1L));
    }

    /**
     * Method under test: {@link OrderServiceImplementation#canceledOrder(Long)}
     */
    @Test
    void testCanceledOrder() throws OrderException {
        assertNull(orderServiceImplementation.canceledOrder(1L));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link OrderServiceImplementation#deleteOrder(Long)}
     *   <li>{@link OrderServiceImplementation#getAllOrders()}
     * </ul>
     */
//    @Test
//    void testDeleteOrder() throws OrderException {
//        CartRepository cartRepository = mock(CartRepository.class);
//        CartRepository cartRepository2 = mock(CartRepository.class);
//        CartItemRepository cartItemRepository = mock(CartItemRepository.class);
//        UserRepository userRepository = mock(UserRepository.class);
//        CartItemServiceImplementation cartItemService = new CartItemServiceImplementation(cartRepository2,
//                cartItemRepository, new UserServiceImplementation(userRepository, new JwtProvider()));
//
//        ProductRepository productRepository = mock(ProductRepository.class);
//        UserRepository userRepository2 = mock(UserRepository.class);
//        OrderServiceImplementation orderServiceImplementation = new OrderServiceImplementation(cartRepository,
//                cartItemService, new ProductServiceImplementation(productRepository,
//                new UserServiceImplementation(userRepository2, new JwtProvider()), mock(CategoryRepository.class)));
//        orderServiceImplementation.deleteOrder(1L);
//        assertNull(orderServiceImplementation.getAllOrders());
//    }
}

