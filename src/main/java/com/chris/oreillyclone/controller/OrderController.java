package com.chris.oreillyclone.controller;

import com.chris.oreillyclone.exception.UserException;
import com.chris.oreillyclone.model.Address;
import com.chris.oreillyclone.model.Order;
import com.chris.oreillyclone.model.User;
import com.chris.oreillyclone.service.OrderService;
import com.chris.oreillyclone.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress,
                                             @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserByJWT(jwt);
        Order order = orderService.createOrder(user,shippingAddress);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>>usersOrderHistory(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserByJWT(jwt);
        List<Order> orders = orderService.getAllOrders();

        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }
}
