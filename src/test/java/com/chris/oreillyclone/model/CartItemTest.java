package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class CartItemTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CartItem#CartItem()}
     *   <li>{@link CartItem#setCart(Cart)}
     *   <li>{@link CartItem#setId(Long)}
     *   <li>{@link CartItem#setPrice(double)}
     *   <li>{@link CartItem#setProduct(Product)}
     *   <li>{@link CartItem#setQuantity(int)}
     *   <li>{@link CartItem#setUserId(Long)}
     *   <li>{@link CartItem#getCart()}
     *   <li>{@link CartItem#getId()}
     *   <li>{@link CartItem#getPrice()}
     *   <li>{@link CartItem#getProduct()}
     *   <li>{@link CartItem#getQuantity()}
     *   <li>{@link CartItem#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CartItem actualCartItem = new CartItem();
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
        Cart cart = new Cart();
        cart.setCartItems(new HashSet<>());
        cart.setId(1L);
        cart.setTotalItems(1000);
        cart.setTotalPrice(10.0d);
        cart.setUser(user);
        actualCartItem.setCart(cart);
        actualCartItem.setId(1L);
        actualCartItem.setPrice(10.0d);
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
        actualCartItem.setProduct(product);
        actualCartItem.setQuantity(1);
        actualCartItem.setUserId(1L);
        Cart actualCart = actualCartItem.getCart();
        Long actualId = actualCartItem.getId();
        double actualPrice = actualCartItem.getPrice();
        Product actualProduct = actualCartItem.getProduct();
        int actualQuantity = actualCartItem.getQuantity();
        Long actualUserId = actualCartItem.getUserId();
        assertSame(cart, actualCart);
        assertEquals(1L, actualId.longValue());
        assertEquals(10.0d, actualPrice);
        assertSame(product, actualProduct);
        assertEquals(1, actualQuantity);
        assertEquals(1L, actualUserId.longValue());
    }

    /**
     * Method under test: {@link CartItem#CartItem(Long, Cart, Product, int, double, Long)}
     */
    @Test
    void testConstructor2() {
        Cart cart = mock(Cart.class);
        Product product = mock(Product.class);
        CartItem actualCartItem = new CartItem(1L, cart, product, 1, 10.0d, 1L);

        assertSame(cart, actualCartItem.getCart());
        assertEquals(1L, actualCartItem.getUserId().longValue());
        assertEquals(1, actualCartItem.getQuantity());
        assertSame(product, actualCartItem.getProduct());
        assertEquals(10.0d, actualCartItem.getPrice());
        assertEquals(1L, actualCartItem.getId().longValue());
    }
}

