package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.OrderException;
import com.chris.oreillyclone.model.Address;
import com.chris.oreillyclone.model.Order;
import com.chris.oreillyclone.model.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address shippingAddress);
    public List<Order> userOrderHistory(Long userid);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order canceledOrder(Long orderId) throws OrderException;

    public List<Order>getAllOrders();
    public void deleteOrder(Long orderId) throws OrderException;
}
