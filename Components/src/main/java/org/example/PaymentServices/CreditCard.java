package org.example.PaymentService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class CreditCard implements Payment{
    @Override
    public void pay() {
        System.out.println("By CreditCard");
    }
}
