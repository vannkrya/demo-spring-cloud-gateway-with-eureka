package com.example.springcloudgateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallback")
    public Mono<String> orderServiceFallback() {
        return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
    }

    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallback() {
        return Mono.just("Payment service is taking too long to respond or is down. Please try again later");
    }

}
