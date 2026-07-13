package com.abhishek.demo.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    //@Autowired                                    //Field Injection - (Connected our PaymentService and OrderService)
    PaymentService paymentService;

    // @Autowired
    OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }                                                    //Constructor Injection


    //@Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }                                                            //Setter Injection

    public void placeOrder(){
        paymentService.payment();
        System.out.println("Order Placed");
    }
}
