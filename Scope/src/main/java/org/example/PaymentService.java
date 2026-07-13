package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaymentService {

    PaymentService() {
        System.out.println("PaymentService created");
    }
    public void pay() {
        System.out.println("Payment Done");
    }
}
