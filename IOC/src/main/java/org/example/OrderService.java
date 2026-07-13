package org.example;

public class OrderService {
    Notification notification = new SMSNotification();

//    OrderService(Notification notification) {
//        this.notification = notification;
//    }

    public void placeOrder() {
        System.out.println("Order Placed");
        notification.sendNotification();
    }

}
