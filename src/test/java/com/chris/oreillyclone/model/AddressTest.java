package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AddressTest {
    /**
     * Method under test: {@link Address#Address()}
     */
    @Test
    void testConstructor() {
        Address actualAddress = new Address();
        assertNull(actualAddress.getCity());
        assertNull(actualAddress.getZipCode());
        assertNull(actualAddress.getUser());
        assertNull(actualAddress.getStreetAddress());
        assertNull(actualAddress.getState());
        assertNull(actualAddress.getMobile());
        assertNull(actualAddress.getLastName());
        assertEquals(0L, actualAddress.getId());
        assertNull(actualAddress.getFirstName());
    }

    /**
     * Method under test: {@link Address#Address(long, String, String, String, String, String, String, User, String)}
     */
    @Test
    void testConstructor2() {
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
        Address actualAddress = new Address(1L, "Jane", "Doe", "42 Main St", "Oxford", "MD", "21654", user, "Mobile");

        assertEquals("Oxford", actualAddress.getCity());
        assertEquals("21654", actualAddress.getZipCode());
        assertSame(user, actualAddress.getUser());
        assertEquals("42 Main St", actualAddress.getStreetAddress());
        assertEquals("Jane", actualAddress.getFirstName());
        assertEquals("Doe", actualAddress.getLastName());
        assertEquals("Mobile", actualAddress.getMobile());
        assertEquals(1L, actualAddress.getId());
        assertEquals("MD", actualAddress.getState());
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals() {
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setFirstName("Jane");
        address.setId(1L);
        address.setLastName("Doe");
        address.setMobile("Mobile");
        address.setState("MD");
        address.setStreetAddress("42 Main St");
        address.setUser(user);
        address.setZipCode("21654");
        assertNotEquals(address, null);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals2() {
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setFirstName("Jane");
        address.setId(1L);
        address.setLastName("Doe");
        address.setMobile("Mobile");
        address.setState("MD");
        address.setStreetAddress("42 Main St");
        address.setUser(user);
        address.setZipCode("21654");
        assertNotEquals(address, "Different type to Address");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Address#equals(Object)}
     *   <li>{@link Address#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setFirstName("Jane");
        address.setId(1L);
        address.setLastName("Doe");
        address.setMobile("Mobile");
        address.setState("MD");
        address.setStreetAddress("42 Main St");
        address.setUser(user);
        address.setZipCode("21654");
        assertEquals(address, address);
        int expectedHashCodeResult = address.hashCode();
        assertEquals(expectedHashCodeResult, address.hashCode());
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals4() {
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setFirstName("Jane");
        address.setId(1L);
        address.setLastName("Doe");
        address.setMobile("Mobile");
        address.setState("MD");
        address.setStreetAddress("42 Main St");
        address.setUser(user);
        address.setZipCode("21654");

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

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setFirstName("Jane");
        address2.setId(1L);
        address2.setLastName("Doe");
        address2.setMobile("Mobile");
        address2.setState("MD");
        address2.setStreetAddress("42 Main St");
        address2.setUser(user2);
        address2.setZipCode("21654");
        assertNotEquals(address, address2);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals5() {
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setFirstName("Jane");
        address.setId(1L);
        address.setLastName("Doe");
        address.setMobile("Mobile");
        address.setState("MD");
        address.setStreetAddress("42 Main St");
        address.setUser(user);
        address.setZipCode("21654");

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

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setFirstName("Jane");
        address2.setId(1L);
        address2.setLastName("Doe");
        address2.setMobile("Mobile");
        address2.setState("MD");
        address2.setStreetAddress("42 Main St");
        address2.setUser(user2);
        address2.setZipCode("21654");
        assertNotEquals(address, address2);
    }
}

