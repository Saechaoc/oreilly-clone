package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.ProductException;
import com.chris.oreillyclone.model.Cart;
import com.chris.oreillyclone.model.CartItem;
import com.chris.oreillyclone.model.Product;
import com.chris.oreillyclone.model.User;
import com.chris.oreillyclone.repository.CartRepository;
import com.chris.oreillyclone.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService{
    private final CartRepository cartRepository;
    private final CartItemService cartItemService;
    private final ProductService productService;

    public CartServiceImplementation(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public void addCartItem(Long userId, AddItemRequest req) throws ProductException {
        Cart cart = cartRepository.findByUserId(userId);
        Product product = productService.findProductById(req.getProductId());

        CartItem isPresent = cartItemService.isCartItemSet(cart, product, userId);

        if (isPresent == null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setUserId(userId);

            double price = req.getPrice() * req.getQuantity();
            cartItem.setPrice(price);

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem);
        }
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        cart.calculateTotalPrice();
        cart.calculateTotalItems();
        return cartRepository.save(cart);
    }
}
