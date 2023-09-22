package com.chris.oreillyclone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.chris.oreillyclone.exception.ProductException;
import com.chris.oreillyclone.model.Cart;
import com.chris.oreillyclone.model.CartItem;
import com.chris.oreillyclone.model.Category;
import com.chris.oreillyclone.model.Product;
import com.chris.oreillyclone.model.User;
import com.chris.oreillyclone.repository.CartRepository;
import com.chris.oreillyclone.request.AddItemRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class CartServiceImplementationTest {
    @MockBean
    private CartItemService cartItemService;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartServiceImplementation cartServiceImplementation;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link CartServiceImplementation#createCart(User)}
     */
    @Test
    void testCreateCart() {
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
        when(cartRepository.save(Mockito.<Cart>any())).thenReturn(cart);

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
        assertSame(cart, cartServiceImplementation.createCart(user2));
        verify(cartRepository).save(Mockito.<Cart>any());
    }

    /**
     * Method under test: {@link CartServiceImplementation#addCartItem(Long, AddItemRequest)}
     */
    @Test
    void testAddCartItem() throws ProductException {
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
        when(cartRepository.findByUserId(Mockito.<Long>any())).thenReturn(cart);

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

        Cart cart2 = new Cart();
        cart2.setCartItems(new HashSet<>());
        cart2.setId(1L);
        cart2.setTotalItems(1000);
        cart2.setTotalPrice(10.0d);
        cart2.setUser(user2);

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

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart2);
        cartItem.setId(1L);
        cartItem.setPrice(10.0d);
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setUserId(1L);
        when(cartItemService.isCartItemSet(Mockito.<Cart>any(), Mockito.<Product>any(), Mockito.<Long>any()))
                .thenReturn(cartItem);

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("Name");
        parentCategory3.setParentCategory(new Category());

        Category parentCategory4 = new Category();
        parentCategory4.setId(1L);
        parentCategory4.setLevel(1);
        parentCategory4.setName("Name");
        parentCategory4.setParentCategory(parentCategory3);

        Category parentCategory5 = new Category();
        parentCategory5.setId(1L);
        parentCategory5.setLevel(1);
        parentCategory5.setName("Name");
        parentCategory5.setParentCategory(parentCategory4);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setLevel(1);
        category2.setName("Name");
        category2.setParentCategory(parentCategory5);

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product2.setDescription("The characteristics of someone or something");
        product2.setId(1L);
        product2.setImageUrl("https://example.org/example");
        product2.setNumRatings(10);
        product2.setPrice(10.0d);
        product2.setProductFamily("Product Family");
        product2.setProductLine("Product Line");
        product2.setQuantity(1);
        product2.setRatingList(new ArrayList<>());
        product2.setReviewList(new ArrayList<>());
        product2.setTitle("Dr");
        when(productService.findProductById(Mockito.<Long>any())).thenReturn(product2);
        AddItemRequest req = new AddItemRequest();
        cartServiceImplementation.addCartItem(1L, req);
        verify(cartRepository).findByUserId(Mockito.<Long>any());
        verify(cartItemService).isCartItemSet(Mockito.<Cart>any(), Mockito.<Product>any(), Mockito.<Long>any());
        verify(productService).findProductById(Mockito.<Long>any());
        assertEquals(0.0d, req.getPrice());
        assertEquals(0, req.getQuantity());
    }

    /**
     * Method under test: {@link CartServiceImplementation#addCartItem(Long, AddItemRequest)}
     */
    @Test
    void testAddCartItem2() throws ProductException {
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
        when(cartRepository.findByUserId(Mockito.<Long>any())).thenReturn(cart);
        when(productService.findProductById(Mockito.<Long>any())).thenThrow(new ProductException("An error occurred"));
        assertThrows(ProductException.class, () -> cartServiceImplementation.addCartItem(1L, new AddItemRequest()));
        verify(cartRepository).findByUserId(Mockito.<Long>any());
        verify(productService).findProductById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CartServiceImplementation#findUserCart(Long)}
     */
    @Test
    void testFindUserCart() {
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

        Cart cart2 = new Cart();
        cart2.setCartItems(new HashSet<>());
        cart2.setId(1L);
        cart2.setTotalItems(1000);
        cart2.setTotalPrice(10.0d);
        cart2.setUser(user2);
        when(cartRepository.save(Mockito.<Cart>any())).thenReturn(cart2);
        when(cartRepository.findByUserId(Mockito.<Long>any())).thenReturn(cart);
        assertSame(cart2, cartServiceImplementation.findUserCart(1L));
        verify(cartRepository).findByUserId(Mockito.<Long>any());
        verify(cartRepository).save(Mockito.<Cart>any());
    }

    /**
     * Method under test: {@link CartServiceImplementation#findUserCart(Long)}
     */
    @Test
    void testFindUserCart2() {
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

        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category category = new Category();
        category.setId(1L);
        category.setLevel(1);
        category.setName("Name");
        category.setParentCategory(parentCategory);

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

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setId(1L);
        cartItem.setPrice(10.0d);
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setUserId(1L);

        HashSet<CartItem> cartItems = new HashSet<>();
        cartItems.add(cartItem);

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

        Cart cart2 = new Cart();
        cart2.setCartItems(cartItems);
        cart2.setId(1L);
        cart2.setTotalItems(1000);
        cart2.setTotalPrice(10.0d);
        cart2.setUser(user2);

        User user3 = new User();
        user3.setAddressList(new ArrayList<>());
        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setId(1L);
        user3.setLastName("Doe");
        user3.setMobile("Mobile");
        user3.setPassword("iloveyou");
        user3.setPaymentInformationList(new ArrayList<>());
        user3.setRatingList(new ArrayList<>());
        user3.setReviewList(new ArrayList<>());
        user3.setRole("Role");

        Cart cart3 = new Cart();
        cart3.setCartItems(new HashSet<>());
        cart3.setId(1L);
        cart3.setTotalItems(1000);
        cart3.setTotalPrice(10.0d);
        cart3.setUser(user3);
        when(cartRepository.save(Mockito.<Cart>any())).thenReturn(cart3);
        when(cartRepository.findByUserId(Mockito.<Long>any())).thenReturn(cart2);
        assertSame(cart3, cartServiceImplementation.findUserCart(1L));
        verify(cartRepository).findByUserId(Mockito.<Long>any());
        verify(cartRepository).save(Mockito.<Cart>any());
    }
}

