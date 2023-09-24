//package com.chris.oreillyclone.model;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//
//class ProductTest {
//    /**
//     * Method under test: {@link Product#Product()}
//     */
//    @Test
//    void testConstructor() {
//        Product actualProduct = new Product();
//        assertNull(actualProduct.getCategory());
//        assertNull(actualProduct.getTitle());
//        List<Review> reviewList = actualProduct.getReviewList();
//        assertTrue(reviewList.isEmpty());
//        List<Rating> ratingList = actualProduct.getRatingList();
//        assertEquals(reviewList, ratingList);
//        assertTrue(ratingList.isEmpty());
//        assertEquals(0, actualProduct.getQuantity());
//        assertNull(actualProduct.getProductLine());
//        assertNull(actualProduct.getProductFamily());
//        assertEquals(0.0d, actualProduct.getPrice());
//        assertEquals(0, actualProduct.getNumRatings());
//        assertNull(actualProduct.getImageUrl());
//        assertNull(actualProduct.getId());
//        assertNull(actualProduct.getDescription());
//        assertNull(actualProduct.getCreatedAt());
//    }
//
//    /**
//     * Method under test: {@link Product#Product(Long, String, String, double, String, String, String, List, int, Category, LocalDateTime)}
//     */
//    @Test
//    void testConstructor2() {
//        ArrayList<Rating> ratingList = new ArrayList<>();
//
//        Category parentCategory = new Category();
//        parentCategory.setId(1L);
//        parentCategory.setLevel(1);
//        parentCategory.setName("Name");
//        parentCategory.setParentCategory(new Category());
//
//        Category parentCategory2 = new Category();
//        parentCategory2.setId(1L);
//        parentCategory2.setLevel(1);
//        parentCategory2.setName("Name");
//        parentCategory2.setParentCategory(parentCategory);
//
//        Category parentCategory3 = new Category();
//        parentCategory3.setId(1L);
//        parentCategory3.setLevel(1);
//        parentCategory3.setName("Name");
//        parentCategory3.setParentCategory(parentCategory2);
//
//        Category parentCategory4 = new Category();
//        parentCategory4.setId(1L);
//        parentCategory4.setLevel(1);
//        parentCategory4.setName("Name");
//        parentCategory4.setParentCategory(parentCategory3);
//
//        Category cateogry = new Category();
//        cateogry.setId(1L);
//        cateogry.setLevel(1);
//        cateogry.setName("Name");
//        cateogry.setParentCategory(parentCategory4);
//        Product actualProduct = new Product(1L, "Dr", "The characteristics of someone or something", 10.0d,
//                "Product Line", "Product Family", "https://example.org/example", ratingList, 10, cateogry,
//                LocalDate.of(1970, 1, 1).atStartOfDay());
//
//        assertSame(cateogry, actualProduct.getCategory());
//        assertEquals("Dr", actualProduct.getTitle());
//        assertEquals(1L, actualProduct.getId().longValue());
//        assertEquals("Product Family", actualProduct.getProductFamily());
//        assertEquals("1970-01-01", actualProduct.getCreatedAt().toLocalDate().toString());
//        assertEquals("Product Line", actualProduct.getProductLine());
//        List<Review> reviewList = actualProduct.getReviewList();
//        assertEquals(ratingList, reviewList);
//        assertEquals(reviewList, actualProduct.getRatingList());
//        assertEquals("https://example.org/example", actualProduct.getImageUrl());
//        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
//        assertEquals(10.0d, actualProduct.getPrice());
//        assertEquals(10, actualProduct.getNumRatings());
//    }
//
//    /**
//     * Method under test: {@link Product#Product(Long, String, String, double, String, String, String, List, int, Category, LocalDateTime)}
//     */
//    @Test
//    void testConstructor3() {
//        Category parentCategory = new Category();
//        parentCategory.setId(1L);
//        parentCategory.setLevel(1);
//        parentCategory.setName("Name");
//        parentCategory.setParentCategory(new Category());
//
//        Category category = new Category();
//        category.setId(1L);
//        category.setLevel(1);
//        category.setName("Name");
//        category.setParentCategory(parentCategory);
//
//        Product product = new Product();
//        product.setCategory(category);
//        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        product.setDescription("The characteristics of someone or something");
//        product.setId(1L);
//        product.setImageUrl("https://example.org/example");
//        product.setNumRatings(10);
//        product.setPrice(10.0d);
//        product.setProductFamily("Product Family");
//        product.setProductLine("Product Line");
//        product.setQuantity(1);
//        ArrayList<Rating> ratingList = new ArrayList<>();
//        product.setRatingList(ratingList);
//        product.setReviewList(new ArrayList<>());
//        product.setTitle("Dr");
//
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//
//        Rating rating = new Rating();
//        rating.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        rating.setId(1L);
//        rating.setProduct(product);
//        rating.setRating(10.0d);
//        rating.setUser(user);
//
//        ArrayList<Rating> ratingList2 = new ArrayList<>();
//        ratingList2.add(rating);
//
//        Category parentCategory2 = new Category();
//        parentCategory2.setId(1L);
//        parentCategory2.setLevel(1);
//        parentCategory2.setName("Name");
//        parentCategory2.setParentCategory(new Category());
//
//        Category parentCategory3 = new Category();
//        parentCategory3.setId(1L);
//        parentCategory3.setLevel(1);
//        parentCategory3.setName("Name");
//        parentCategory3.setParentCategory(parentCategory2);
//
//        Category parentCategory4 = new Category();
//        parentCategory4.setId(1L);
//        parentCategory4.setLevel(1);
//        parentCategory4.setName("Name");
//        parentCategory4.setParentCategory(parentCategory3);
//
//        Category parentCategory5 = new Category();
//        parentCategory5.setId(1L);
//        parentCategory5.setLevel(1);
//        parentCategory5.setName("Name");
//        parentCategory5.setParentCategory(parentCategory4);
//
//        Category cateogry = new Category();
//        cateogry.setId(1L);
//        cateogry.setLevel(1);
//        cateogry.setName("Name");
//        cateogry.setParentCategory(parentCategory5);
//        Product actualProduct = new Product(1L, "Dr", "The characteristics of someone or something", 10.0d,
//                "Product Line", "Product Family", "https://example.org/example", ratingList2, 10, cateogry,
//                LocalDate.of(1970, 1, 1).atStartOfDay());
//
//        assertSame(cateogry, actualProduct.getCategory());
//        assertEquals("Dr", actualProduct.getTitle());
//        assertEquals(1L, actualProduct.getId().longValue());
//        assertEquals("Product Family", actualProduct.getProductFamily());
//        assertEquals("1970-01-01", actualProduct.getCreatedAt().toLocalDate().toString());
//        assertEquals("Product Line", actualProduct.getProductLine());
//        assertEquals(ratingList, actualProduct.getReviewList());
//        assertEquals(1, actualProduct.getRatingList().size());
//        assertEquals("https://example.org/example", actualProduct.getImageUrl());
//        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
//        assertEquals(10, actualProduct.getNumRatings());
//        assertEquals(10.0d, actualProduct.getPrice());
//    }
//
//    /**
//     * Method under test: {@link Product#Product(Long, String, String, double, String, String, String, List, int, Category, LocalDateTime)}
//     */
//    @Test
//    void testConstructor4() {
//        Category parentCategory = new Category();
//        parentCategory.setId(1L);
//        parentCategory.setLevel(1);
//        parentCategory.setName("Name");
//        parentCategory.setParentCategory(new Category());
//
//        Category category = new Category();
//        category.setId(1L);
//        category.setLevel(1);
//        category.setName("Name");
//        category.setParentCategory(parentCategory);
//
//        Product product = new Product();
//        product.setCategory(category);
//        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        product.setDescription("The characteristics of someone or something");
//        product.setId(1L);
//        product.setImageUrl("https://example.org/example");
//        product.setNumRatings(10);
//        product.setPrice(10.0d);
//        product.setProductFamily("Product Family");
//        product.setProductLine("Product Line");
//        product.setQuantity(1);
//        ArrayList<Rating> ratingList = new ArrayList<>();
//        product.setRatingList(ratingList);
//        product.setReviewList(new ArrayList<>());
//        product.setTitle("Dr");
//
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//
//        Rating rating = new Rating();
//        rating.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        rating.setId(1L);
//        rating.setProduct(product);
//        rating.setRating(10.0d);
//        rating.setUser(user);
//
//        Category parentCategory2 = new Category();
//        parentCategory2.setId(2L);
//        parentCategory2.setLevel(0);
//        parentCategory2.setName("42");
//        parentCategory2.setParentCategory(new Category());
//
//        Category category2 = new Category();
//        category2.setId(2L);
//        category2.setLevel(0);
//        category2.setName("42");
//        category2.setParentCategory(parentCategory2);
//
//        Product product2 = new Product();
//        product2.setCategory(category2);
//        product2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        product2.setDescription("Description");
//        product2.setId(2L);
//        product2.setImageUrl("Image Url");
//        product2.setNumRatings(1);
//        product2.setPrice(0.5d);
//        product2.setProductFamily("42");
//        product2.setProductLine("42");
//        product2.setQuantity(0);
//        product2.setRatingList(new ArrayList<>());
//        product2.setReviewList(new ArrayList<>());
//        product2.setTitle("Mr");
//
//        User user2 = new User();
//        user2.setAddressList(new ArrayList<>());
//        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user2.setEmail("john.smith@example.org");
//        user2.setFirstName("John");
//        user2.setId(2L);
//        user2.setLastName("Smith");
//        user2.setMobile("42");
//        user2.setPassword("Password");
//        user2.setPaymentInformationList(new ArrayList<>());
//        user2.setRatingList(new ArrayList<>());
//        user2.setReviewList(new ArrayList<>());
//        user2.setRole("42");
//
//        Rating rating2 = new Rating();
//        rating2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        rating2.setId(2L);
//        rating2.setProduct(product2);
//        rating2.setRating(0.5d);
//        rating2.setUser(user2);
//
//        ArrayList<Rating> ratingList2 = new ArrayList<>();
//        ratingList2.add(rating2);
//        ratingList2.add(rating);
//
//        Category parentCategory3 = new Category();
//        parentCategory3.setId(1L);
//        parentCategory3.setLevel(1);
//        parentCategory3.setName("Name");
//        parentCategory3.setParentCategory(new Category());
//
//        Category parentCategory4 = new Category();
//        parentCategory4.setId(1L);
//        parentCategory4.setLevel(1);
//        parentCategory4.setName("Name");
//        parentCategory4.setParentCategory(parentCategory3);
//
//        Category parentCategory5 = new Category();
//        parentCategory5.setId(1L);
//        parentCategory5.setLevel(1);
//        parentCategory5.setName("Name");
//        parentCategory5.setParentCategory(parentCategory4);
//
//        Category parentCategory6 = new Category();
//        parentCategory6.setId(1L);
//        parentCategory6.setLevel(1);
//        parentCategory6.setName("Name");
//        parentCategory6.setParentCategory(parentCategory5);
//
//        Category cateogry = new Category();
//        cateogry.setId(1L);
//        cateogry.setLevel(1);
//        cateogry.setName("Name");
//        cateogry.setParentCategory(parentCategory6);
//        Product actualProduct = new Product(1L, "Dr", "The characteristics of someone or something", 10.0d,
//                "Product Line", "Product Family", "https://example.org/example", ratingList2, 10, cateogry,
//                LocalDate.of(1970, 1, 1).atStartOfDay());
//
//        assertSame(cateogry, actualProduct.getCategory());
//        assertEquals("Dr", actualProduct.getTitle());
//        assertEquals(1L, actualProduct.getId().longValue());
//        assertEquals("Product Family", actualProduct.getProductFamily());
//        assertEquals("1970-01-01", actualProduct.getCreatedAt().toLocalDate().toString());
//        assertEquals("Product Line", actualProduct.getProductLine());
//        assertEquals(ratingList, actualProduct.getReviewList());
//        assertEquals(2, actualProduct.getRatingList().size());
//        assertEquals("https://example.org/example", actualProduct.getImageUrl());
//        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
//        assertEquals(10, actualProduct.getNumRatings());
//        assertEquals(10.0d, actualProduct.getPrice());
//    }
//}
//
