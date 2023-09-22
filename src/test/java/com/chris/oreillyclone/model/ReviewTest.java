package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReviewTest {
    /**
     * Method under test: {@link Review#Review()}
     */
    @Test
    void testConstructor() {
        Review actualReview = new Review();
        assertNull(actualReview.getCreatedAt());
        assertNull(actualReview.getUser());
        assertNull(actualReview.getReview());
        assertNull(actualReview.getProduct());
        assertNull(actualReview.getId());
    }

    /**
     * Method under test: {@link Review#Review(Long, String, Product, User, LocalDateTime)}
     */
    @Test
    void testConstructor2() {
        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        Category parentCategory2 = new Category();
        parentCategory.setParentCategory(parentCategory2);

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("Name");
        parentCategory3.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(1L);
        category.setLevel(1);
        category.setName("Name");
        category.setParentCategory(parentCategory3);

        Product product = new Product();
        product.setCategory(category);
        LocalDate ofResult = LocalDate.of(1970, 1, 1);
        product.setCreatedAt(ofResult.atStartOfDay());
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImageUrl("https://example.org/example");
        product.setNumRatings(10);
        product.setPrice(10.0d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(1);
        ArrayList<Rating> ratingList = new ArrayList<>();
        product.setRatingList(ratingList);
        ArrayList<Review> reviewList = new ArrayList<>();
        product.setReviewList(reviewList);
        product.setTitle("Dr");

        User user = new User();
        ArrayList<Address> addressList = new ArrayList<>();
        user.setAddressList(addressList);
        LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
        user.setCreatedAt(ofResult2.atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setMobile("Mobile");
        user.setPassword("iloveyou");
        ArrayList<PaymentInformation> paymentInformationList = new ArrayList<>();
        user.setPaymentInformationList(paymentInformationList);
        ArrayList<Rating> ratingList2 = new ArrayList<>();
        user.setRatingList(ratingList2);
        ArrayList<Review> reviewList2 = new ArrayList<>();
        user.setReviewList(reviewList2);
        user.setRole("Role");
        LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
        LocalDateTime createdAt = ofResult3.atStartOfDay();
        Review actualReview = new Review(1L, "Review", product, user, createdAt);

        LocalDateTime createdAt2 = actualReview.getCreatedAt();
        assertSame(createdAt, createdAt2);
        User user2 = actualReview.getUser();
        assertSame(user, user2);
        assertEquals("00:00", createdAt2.toLocalTime().toString());
        assertEquals(1L, actualReview.getId().longValue());
        assertEquals("Review", actualReview.getReview());
        LocalDate toLocalDateResult = createdAt2.toLocalDate();
        assertSame(ofResult3, toLocalDateResult);
        assertEquals("1970-01-01", toLocalDateResult.toString());
        Product product2 = actualReview.getProduct();
        assertSame(product, product2);
        assertEquals("iloveyou", user2.getPassword());
        assertEquals("Dr", product2.getTitle());
        List<Review> reviewList3 = product2.getReviewList();
        assertSame(reviewList, reviewList3);
        assertEquals(ratingList, reviewList3);
        assertEquals(addressList, reviewList3);
        assertEquals(paymentInformationList, reviewList3);
        assertEquals(ratingList2, reviewList3);
        assertEquals(reviewList2, reviewList3);
        assertTrue(reviewList3.isEmpty());
        List<Rating> ratingList3 = product2.getRatingList();
        assertSame(ratingList, ratingList3);
        assertEquals(addressList, ratingList3);
        assertEquals(paymentInformationList, ratingList3);
        assertEquals(ratingList2, ratingList3);
        assertEquals(reviewList2, ratingList3);
        assertEquals(reviewList3, ratingList3);
        assertTrue(ratingList3.isEmpty());
        assertEquals(1, product2.getQuantity());
        assertEquals("Product Line", product2.getProductLine());
        assertEquals("Product Family", product2.getProductFamily());
        assertEquals(10.0d, product2.getPrice());
        assertEquals(10, product2.getNumRatings());
        assertEquals("https://example.org/example", product2.getImageUrl());
        assertEquals(1L, product2.getId().longValue());
        assertEquals("The characteristics of someone or something", product2.getDescription());
        Category category2 = product2.getCategory();
        assertSame(category, category2);
        LocalDateTime createdAt3 = product2.getCreatedAt();
        assertEquals("00:00", createdAt3.toLocalTime().toString());
        List<Rating> ratingList4 = user2.getRatingList();
        assertSame(ratingList2, ratingList4);
        assertEquals(addressList, ratingList4);
        assertEquals(paymentInformationList, ratingList4);
        assertEquals(reviewList2, ratingList4);
        assertEquals(ratingList3, ratingList4);
        assertEquals(reviewList3, ratingList4);
        assertTrue(ratingList4.isEmpty());
        assertEquals("Role", user2.getRole());
        assertEquals("jane.doe@example.org", user2.getEmail());
        assertEquals("Jane", user2.getFirstName());
        LocalDate toLocalDateResult2 = createdAt3.toLocalDate();
        assertSame(ofResult, toLocalDateResult2);
        assertEquals("1970-01-01", toLocalDateResult2.toString());
        assertEquals("Mobile", user2.getMobile());
        assertEquals("Doe", user2.getLastName());
        List<Review> reviewList4 = user2.getReviewList();
        assertSame(reviewList2, reviewList4);
        assertEquals(addressList, reviewList4);
        assertEquals(paymentInformationList, reviewList4);
        assertEquals(ratingList4, reviewList4);
        assertEquals(ratingList3, reviewList4);
        assertEquals(reviewList3, reviewList4);
        assertTrue(reviewList4.isEmpty());
        assertEquals(1L, user2.getId().longValue());
        List<PaymentInformation> paymentInformationList2 = user2.getPaymentInformationList();
        assertSame(paymentInformationList, paymentInformationList2);
        assertEquals(addressList, paymentInformationList2);
        assertEquals(ratingList4, paymentInformationList2);
        assertEquals(reviewList4, paymentInformationList2);
        assertEquals(ratingList3, paymentInformationList2);
        assertEquals(reviewList3, paymentInformationList2);
        assertTrue(paymentInformationList2.isEmpty());
        List<Address> addressList2 = user2.getAddressList();
        assertSame(addressList, addressList2);
        assertEquals(paymentInformationList2, addressList2);
        assertEquals(ratingList4, addressList2);
        assertEquals(reviewList4, addressList2);
        assertEquals(ratingList3, addressList2);
        assertEquals(reviewList3, addressList2);
        assertTrue(addressList2.isEmpty());
        LocalDateTime createdAt4 = user2.getCreatedAt();
        assertEquals("00:00", createdAt4.toLocalTime().toString());
        LocalDate toLocalDateResult3 = createdAt4.toLocalDate();
        assertSame(ofResult2, toLocalDateResult3);
        assertEquals("1970-01-01", toLocalDateResult3.toString());
        assertEquals(1L, category2.getId().longValue());
        assertEquals(1, category2.getLevel());
        Category parentCategory4 = category2.getParentCategory();
        assertSame(parentCategory3, parentCategory4);
        assertEquals("Name", category2.getName());
        Category parentCategory5 = parentCategory4.getParentCategory();
        assertSame(parentCategory, parentCategory5);
        assertEquals("Name", parentCategory4.getName());
        assertEquals(1L, parentCategory4.getId().longValue());
        assertEquals(1, parentCategory4.getLevel());
        assertEquals(1, parentCategory5.getLevel());
        assertEquals(1L, parentCategory5.getId().longValue());
        assertEquals("Name", parentCategory5.getName());
        Category parentCategory6 = parentCategory5.getParentCategory();
        assertSame(parentCategory2, parentCategory6);
        assertNull(parentCategory6.getId());
    }
}

