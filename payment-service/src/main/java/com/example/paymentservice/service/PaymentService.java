package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();

    Payment doPayment(Payment paymentRequest);

    Payment findPaymentHistoryByOrderId(Long orderId);
}
