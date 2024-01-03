package com.example.orderservice.common;

import com.example.orderservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {
    private Order order;
    private Double amount;
    private String transactionId;
    private String message;
}
