package com.example.orderservice.controller;

import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/message")
    public String testMessage() {
        return "testing message";
    }

    @PostMapping("/bookOrder")
    public ResponseEntity<TransactionResponse> bookOrder(@RequestBody TransactionRequest transactionRequest) {
//        Order order = orderService.bookOrder(orderRequest);
//        return ResponseEntity.ok().body(order);
        TransactionResponse transactionResponse = orderService.bookOrder(transactionRequest);
        return ResponseEntity.ok().body(transactionResponse);
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return ResponseEntity.ok().body(orderList);
    }
}
