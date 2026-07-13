package org.example;

public class Main {
    public static void main(String[] args) {
        Notification notification = new SMSNotification();
        OrderService orderService = new OrderService(notification);
        orderService.placeOrder();
    }
}