package org.example.PaymentService;

public class Paypal implements Payment{

    @Override
    public void pay() {
        System.out.println("Payment By PayPal");
    }
}
