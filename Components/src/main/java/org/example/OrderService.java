package org.example;

import org.example.PaymentService.Payment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@org.example.Component
public class OrderService {
    Payment payment;

    OrderService(@Qualifier("creditCard") Payment payment) {
        this.payment = payment;
    }

//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }

    public void PlaceOrder() {
        System.out.println("Order Placed");
    }
}
