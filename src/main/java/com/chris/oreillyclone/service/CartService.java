package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.ProductException;
import com.chris.oreillyclone.model.Cart;
import com.chris.oreillyclone.model.User;
import com.chris.oreillyclone.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);

    public void addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);
}
