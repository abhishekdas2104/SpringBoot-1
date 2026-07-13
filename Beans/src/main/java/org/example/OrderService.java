package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class OrderService {
//    @Autowired
    PaymentService paymentService;

    @Autowired
    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


//    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
