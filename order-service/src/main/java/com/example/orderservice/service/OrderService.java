package com.example.orderservice.service;

import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import com.example.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

     TransactionResponse bookOrder(TransactionRequest transactionRequest);
}
