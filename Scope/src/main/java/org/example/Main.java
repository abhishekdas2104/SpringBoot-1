package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService1 = context.getBean(OrderService.class);

        orderService1.placeOrder();

//        OrderService orderService2 = context.getBean(OrderService.class);
//
//        if(orderService1 == orderService2)
//        {
//            System.out.println("They are same");
//        }
//        else {
//            System.out.println("They are not same");
//        }

    }
}