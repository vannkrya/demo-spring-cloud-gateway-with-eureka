package com.example.paymentservice.service.implementation;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import com.example.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PaymentServiceImplementation implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment doPayment(Payment paymentRequest) {
        paymentRequest.setStatus(paymentProcessing());
        return paymentRepository.save(paymentRequest);
    }

    @Override
    public Payment findPaymentHistoryByOrderId(Long orderId) {
        return null;
    }

    public String paymentProcessing() {
        return new Random().nextBoolean()?"success":"false";
    }
}
