package org.example;


import org.example.PaymentService.CreditCard;
import org.example.PaymentService.Payment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.PlaceOrder();

        Payment payment = context.getBean(CreditCard.class);
        payment.pay();
    }
}