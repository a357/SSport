package com.smartsport.demo.order.service;

import com.smartsport.demo.domain.Order;

public interface OrderService {
    Order addOrder(Order order);
    Order getOrder(String id);
    Order updateOrder(Order order);
    void deleteOrder(String id);
    Iterable<Order> getAllOrder();
    Order generateOrder();
}
