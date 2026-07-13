package org.example;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    OrderService orderService;
//
//    PaymentService(OrderService orderService) {
//        this.orderService = orderService;
//    }

    public void pay() {
        System.out.println("Payment Done");
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
