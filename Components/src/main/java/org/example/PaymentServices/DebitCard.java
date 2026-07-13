package org.example.PaymentService;

import org.springframework.stereotype.Component;

@Component

public class DebitCard implements Payment {
    @Override
    public void pay() {
        System.out.println("By DebitCard");
    }
}
