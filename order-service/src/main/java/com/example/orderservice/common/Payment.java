package com.example.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {

    private Long id;
    private String status;
    private String transactionId;

    private Long orderId;
    private Double amount;
}
