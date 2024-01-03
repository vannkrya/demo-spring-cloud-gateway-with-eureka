package com.example.orderservice.service.implementation;

import com.example.orderservice.common.Payment;
import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public TransactionResponse bookOrder(TransactionRequest transactionRequest) {
//        Order order = orderRepository
//        return orderRepository.save(orderRequest);
        String response = "";
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject(
                "http://localhost:8082/payment-service/payments/doPayment",
//                "http://payment-service/payments/doPayment",
                payment,
                Payment.class);

        assert paymentResponse != null;
        response = paymentResponse.getStatus().equals("success")?
                "payment processing successful and order placed":
                "there is a failure in payment api, order added to cart";


         orderRepository.save(order);

         return new TransactionResponse(order,
                 paymentResponse.getAmount(),
                 paymentResponse.getTransactionId(),
                 response
         );
    }

}
