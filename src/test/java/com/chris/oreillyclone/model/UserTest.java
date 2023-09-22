package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAddressList(List)}
     *   <li>{@link User#setCreatedAt(LocalDateTime)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setMobile(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setPaymentInformationList(List)}
     *   <li>{@link User#setRatingList(List)}
     *   <li>{@link User#setReviewList(List)}
     *   <li>{@link User#setRole(String)}
     *   <li>{@link User#getAddressList()}
     *   <li>{@link User#getCreatedAt()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getMobile()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getPaymentInformationList()}
     *   <li>{@link User#getRatingList()}
     *   <li>{@link User#getReviewList()}
     *   <li>{@link User#getRole()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        ArrayList<Address> addressList = new ArrayList<>();
        actualUser.setAddressList(addressList);
        LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualUser.setCreatedAt(createdAt);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(1L);
        actualUser.setLastName("Doe");
        actualUser.setMobile("Mobile");
        actualUser.setPassword("iloveyou");
        ArrayList<PaymentInformation> paymentInformationList = new ArrayList<>();
        actualUser.setPaymentInformationList(paymentInformationList);
        ArrayList<Rating> ratingList = new ArrayList<>();
        actualUser.setRatingList(ratingList);
        ArrayList<Review> reviewList = new ArrayList<>();
        actualUser.setReviewList(reviewList);
        actualUser.setRole("Role");
        List<Address> actualAddressList = actualUser.getAddressList();
        LocalDateTime actualCreatedAt = actualUser.getCreatedAt();
        String actualEmail = actualUser.getEmail();
        String actualFirstName = actualUser.getFirstName();
        Long actualId = actualUser.getId();
        String actualLastName = actualUser.getLastName();
        String actualMobile = actualUser.getMobile();
        String actualPassword = actualUser.getPassword();
        List<PaymentInformation> actualPaymentInformationList = actualUser.getPaymentInformationList();
        List<Rating> actualRatingList = actualUser.getRatingList();
        List<Review> actualReviewList = actualUser.getReviewList();
        String actualRole = actualUser.getRole();
        assertSame(addressList, actualAddressList);
        assertEquals(paymentInformationList, actualAddressList);
        assertEquals(ratingList, actualAddressList);
        assertEquals(reviewList, actualAddressList);
        assertSame(createdAt, actualCreatedAt);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("Jane", actualFirstName);
        assertEquals(1L, actualId.longValue());
        assertEquals("Doe", actualLastName);
        assertEquals("Mobile", actualMobile);
        assertEquals("iloveyou", actualPassword);
        assertSame(paymentInformationList, actualPaymentInformationList);
        assertEquals(ratingList, actualPaymentInformationList);
        assertEquals(reviewList, actualPaymentInformationList);
        assertEquals(actualAddressList, actualPaymentInformationList);
        assertSame(ratingList, actualRatingList);
        assertEquals(reviewList, actualRatingList);
        assertEquals(actualAddressList, actualRatingList);
        assertEquals(actualPaymentInformationList, actualRatingList);
        assertSame(reviewList, actualReviewList);
        assertEquals(actualAddressList, actualReviewList);
        assertEquals(actualPaymentInformationList, actualReviewList);
        assertEquals(actualRatingList, actualReviewList);
        assertEquals("Role", actualRole);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(Long, String, String, String, String, String, String, List, List, List, List, LocalDateTime)}
     *   <li>{@link User#setAddressList(List)}
     *   <li>{@link User#setCreatedAt(LocalDateTime)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setMobile(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setPaymentInformationList(List)}
     *   <li>{@link User#setRatingList(List)}
     *   <li>{@link User#setReviewList(List)}
     *   <li>{@link User#setRole(String)}
     *   <li>{@link User#getAddressList()}
     *   <li>{@link User#getCreatedAt()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getMobile()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getPaymentInformationList()}
     *   <li>{@link User#getRatingList()}
     *   <li>{@link User#getReviewList()}
     *   <li>{@link User#getRole()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Address> addressList = new ArrayList<>();
        ArrayList<PaymentInformation> paymentInformationList = new ArrayList<>();
        ArrayList<Rating> ratingList = new ArrayList<>();
        ArrayList<Review> reviewList = new ArrayList<>();
        User actualUser = new User(1L, "Jane", "Doe", "iloveyou", "jane.doe@example.org", "Role", "Mobile", addressList,
                paymentInformationList, ratingList, reviewList, LocalDate.of(1970, 1, 1).atStartOfDay());
        ArrayList<Address> addressList2 = new ArrayList<>();
        actualUser.setAddressList(addressList2);
        LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualUser.setCreatedAt(createdAt);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(1L);
        actualUser.setLastName("Doe");
        actualUser.setMobile("Mobile");
        actualUser.setPassword("iloveyou");
        ArrayList<PaymentInformation> paymentInformationList2 = new ArrayList<>();
        actualUser.setPaymentInformationList(paymentInformationList2);
        ArrayList<Rating> ratingList2 = new ArrayList<>();
        actualUser.setRatingList(ratingList2);
        ArrayList<Review> reviewList2 = new ArrayList<>();
        actualUser.setReviewList(reviewList2);
        actualUser.setRole("Role");
        List<Address> actualAddressList = actualUser.getAddressList();
        LocalDateTime actualCreatedAt = actualUser.getCreatedAt();
        String actualEmail = actualUser.getEmail();
        String actualFirstName = actualUser.getFirstName();
        Long actualId = actualUser.getId();
        String actualLastName = actualUser.getLastName();
        String actualMobile = actualUser.getMobile();
        String actualPassword = actualUser.getPassword();
        List<PaymentInformation> actualPaymentInformationList = actualUser.getPaymentInformationList();
        List<Rating> actualRatingList = actualUser.getRatingList();
        List<Review> actualReviewList = actualUser.getReviewList();
        String actualRole = actualUser.getRole();
        assertSame(addressList2, actualAddressList);
        assertEquals(addressList, actualAddressList);
        assertEquals(paymentInformationList, actualAddressList);
        assertEquals(ratingList, actualAddressList);
        assertEquals(reviewList, actualAddressList);
        assertEquals(paymentInformationList2, actualAddressList);
        assertEquals(ratingList2, actualAddressList);
        assertEquals(reviewList2, actualAddressList);
        assertSame(createdAt, actualCreatedAt);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("Jane", actualFirstName);
        assertEquals(1L, actualId.longValue());
        assertEquals("Doe", actualLastName);
        assertEquals("Mobile", actualMobile);
        assertEquals("iloveyou", actualPassword);
        assertSame(paymentInformationList2, actualPaymentInformationList);
        assertEquals(addressList, actualPaymentInformationList);
        assertEquals(paymentInformationList, actualPaymentInformationList);
        assertEquals(ratingList, actualPaymentInformationList);
        assertEquals(reviewList, actualPaymentInformationList);
        assertEquals(ratingList2, actualPaymentInformationList);
        assertEquals(reviewList2, actualPaymentInformationList);
        assertEquals(actualAddressList, actualPaymentInformationList);
        assertSame(ratingList2, actualRatingList);
        assertEquals(addressList, actualRatingList);
        assertEquals(paymentInformationList, actualRatingList);
        assertEquals(ratingList, actualRatingList);
        assertEquals(reviewList, actualRatingList);
        assertEquals(reviewList2, actualRatingList);
        assertEquals(actualAddressList, actualRatingList);
        assertEquals(actualPaymentInformationList, actualRatingList);
        assertSame(reviewList2, actualReviewList);
        assertEquals(addressList, actualReviewList);
        assertEquals(paymentInformationList, actualReviewList);
        assertEquals(ratingList, actualReviewList);
        assertEquals(reviewList, actualReviewList);
        assertEquals(actualAddressList, actualReviewList);
        assertEquals(actualPaymentInformationList, actualReviewList);
        assertEquals(actualRatingList, actualReviewList);
        assertEquals("Role", actualRole);
    }
}

