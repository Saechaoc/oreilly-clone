package com.chris.oreillyclone.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.chris.oreillyclone.exception.CartItemException;
import com.chris.oreillyclone.exception.UserException;
import com.chris.oreillyclone.model.Cart;
import com.chris.oreillyclone.model.CartItem;
import com.chris.oreillyclone.model.Category;
import com.chris.oreillyclone.model.Product;
import com.chris.oreillyclone.model.User;
import com.chris.oreillyclone.repository.CartItemRepository;
import com.chris.oreillyclone.repository.CartRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartItemServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class CartItemServiceImplementationTest {
    @MockBean
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartItemServiceImplementation cartItemServiceImplementation;

    @MockBean
    private CartRepository cartRepository;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link CartItemServiceImplementation#createCartItem(CartItem)}
     */
    @Test
    void testCreateCartItem() {
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
        cartItem.setCart(cart);
        cartItem.setId(1L);
        cartItem.setPrice(10.0d);
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setUserId(1L);
        when(cartItemRepository.save(Mockito.<CartItem>any())).thenReturn(cartItem);

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

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("Name");
        parentCategory3.setParentCategory(new Category());

        Category category2 = new Category();
        category2.setId(1L);
        category2.setLevel(1);
        category2.setName("Name");
        category2.setParentCategory(parentCategory3);

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

        CartItem cartItem2 = new CartItem();
        cartItem2.setCart(cart2);
        cartItem2.setId(1L);
        cartItem2.setPrice(10.0d);
        cartItem2.setProduct(product2);
        cartItem2.setQuantity(1);
        cartItem2.setUserId(1L);
        assertSame(cartItem, cartItemServiceImplementation.createCartItem(cartItem2));
        verify(cartItemRepository).save(Mockito.<CartItem>any());
    }

    /**
     * Method under test: {@link CartItemServiceImplementation#updateCartItem(Long, Long, CartItem)}
     */
    @Test
    void testUpdateCartItem() throws CartItemException, UserException {
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
        Optional<CartItem> ofResult = Optional.of(cartItem);

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

        Category parentCategory2 = new Category();
        parentCategory2.setId(1L);
        parentCategory2.setLevel(1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(new Category());

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("Name");
        parentCategory3.setParentCategory(parentCategory2);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setLevel(1);
        category2.setName("Name");
        category2.setParentCategory(parentCategory3);

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

        CartItem cartItem2 = new CartItem();
        cartItem2.setCart(cart2);
        cartItem2.setId(1L);
        cartItem2.setPrice(10.0d);
        cartItem2.setProduct(product2);
        cartItem2.setQuantity(1);
        cartItem2.setUserId(1L);
        when(cartItemRepository.save(Mockito.<CartItem>any())).thenReturn(cartItem2);
        when(cartItemRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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
        when(userService.findUserById(Mockito.<Long>any())).thenReturn(user3);

        User user4 = new User();
        user4.setAddressList(new ArrayList<>());
        user4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("jane.doe@example.org");
        user4.setFirstName("Jane");
        user4.setId(1L);
        user4.setLastName("Doe");
        user4.setMobile("Mobile");
        user4.setPassword("iloveyou");
        user4.setPaymentInformationList(new ArrayList<>());
        user4.setRatingList(new ArrayList<>());
        user4.setReviewList(new ArrayList<>());
        user4.setRole("Role");

        Cart cart3 = new Cart();
        cart3.setCartItems(new HashSet<>());
        cart3.setId(1L);
        cart3.setTotalItems(1000);
        cart3.setTotalPrice(10.0d);
        cart3.setUser(user4);

        Category parentCategory4 = new Category();
        parentCategory4.setId(1L);
        parentCategory4.setLevel(1);
        parentCategory4.setName("Name");
        parentCategory4.setParentCategory(new Category());

        Category category3 = new Category();
        category3.setId(1L);
        category3.setLevel(1);
        category3.setName("Name");
        category3.setParentCategory(parentCategory4);

        Product product3 = new Product();
        product3.setCategory(category3);
        product3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product3.setDescription("The characteristics of someone or something");
        product3.setId(1L);
        product3.setImageUrl("https://example.org/example");
        product3.setNumRatings(10);
        product3.setPrice(10.0d);
        product3.setProductFamily("Product Family");
        product3.setProductLine("Product Line");
        product3.setQuantity(1);
        product3.setRatingList(new ArrayList<>());
        product3.setReviewList(new ArrayList<>());
        product3.setTitle("Dr");

        CartItem cartItem3 = new CartItem();
        cartItem3.setCart(cart3);
        cartItem3.setId(1L);
        cartItem3.setPrice(10.0d);
        cartItem3.setProduct(product3);
        cartItem3.setQuantity(1);
        cartItem3.setUserId(1L);
        assertSame(cartItem2, cartItemServiceImplementation.updateCartItem(1L, 1L, cartItem3));
        verify(cartItemRepository).save(Mockito.<CartItem>any());
        verify(cartItemRepository).findById(Mockito.<Long>any());
        verify(userService).findUserById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CartItemServiceImplementation#isCartItemSet(Cart, Product, Long)}
     */
    @Test
    void testIsCartItemSet() {
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
        cartItem.setCart(cart);
        cartItem.setId(1L);
        cartItem.setPrice(10.0d);
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setUserId(1L);
        when(cartItemRepository.isCartItemSet(Mockito.<Cart>any(), Mockito.<Product>any(), Mockito.<Long>any()))
                .thenReturn(cartItem);

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

        Category category2 = new Category();
        category2.setId(1L);
        category2.setLevel(1);
        category2.setName("Name");
        category2.setParentCategory(parentCategory4);

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
        assertSame(cartItem, cartItemServiceImplementation.isCartItemSet(cart2, product2, 1L));
        verify(cartItemRepository).isCartItemSet(Mockito.<Cart>any(), Mockito.<Product>any(), Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CartItemServiceImplementation#removeCartItem(Long, Long)}
     */
    @Test
    void testRemoveCartItem() throws CartItemException, UserException {
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
        Optional<CartItem> ofResult = Optional.of(cartItem);
        doNothing().when(cartItemRepository).deleteById(Mockito.<Long>any());
        when(cartItemRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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
        when(userService.findUserById(Mockito.<Long>any())).thenReturn(user2);
        cartItemServiceImplementation.removeCartItem(1L, 1L);
        verify(cartItemRepository).findById(Mockito.<Long>any());
        verify(cartItemRepository).deleteById(Mockito.<Long>any());
        verify(userService, atLeast(1)).findUserById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CartItemServiceImplementation#findCartItemById(Long)}
     */
    @Test
    void testFindCartItemById() throws CartItemException {
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
        Optional<CartItem> ofResult = Optional.of(cartItem);
        when(cartItemRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(cartItem, cartItemServiceImplementation.findCartItemById(1L));
        verify(cartItemRepository).findById(Mockito.<Long>any());
    }
}

