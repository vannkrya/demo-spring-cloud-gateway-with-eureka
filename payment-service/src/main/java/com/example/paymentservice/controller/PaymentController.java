package com.example.paymentservice.controller;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> paymentList = paymentService.getAllPayments();
        return ResponseEntity.ok().body(paymentList);
    }

    @PostMapping("/doPayment")
    public ResponseEntity<Payment> doPayment(@RequestBody Payment paymentRequest) {
        Payment payment = paymentService.doPayment(paymentRequest);
        return ResponseEntity.ok().body(payment);
    }


    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable Long orderId) {
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }
    

}
