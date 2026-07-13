package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class AppConfig {

//    @Bean
//    PaymentService createPayment() {
//        System.out.println("from AppConfig-1");
//        return new PaymentService();
//    }
//
//    @Bean
//    @Primary
//    PaymentService createPayment1() {
//        System.out.println("from AppConfig-2");
//        return new PaymentService();
//    }

    @Bean
    OrderService createOrderService(PaymentService paymentService) {
        return new OrderService(paymentService);
    }
}
