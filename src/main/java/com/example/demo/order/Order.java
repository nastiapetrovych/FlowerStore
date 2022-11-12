package com.example.demo.order;


import com.example.demo.delivery.Delivery;
import com.example.demo.flower.Flower;
import com.example.demo.payment.Payment;
import java.util.LinkedList;

public class Order {
    LinkedList<Flower> items = new LinkedList<Flower>();
    Payment payment;
    Delivery delivery;
    int price = 0;


    public  void addItem(Flower Item) {
        items.add(Item);
    }
    public  void removeItem(Flower item) {
        items.remove(item);
    }

    public  void setPaymentStrategy(Payment type){
        this.payment = type;
    }

    public void setDeliveryStrategy(Delivery type){
        this.delivery = type;
    }
    public int calculateTotalPrice(){
        for (int i = 0; i < items.size(); i++){
            Flower item = items.get(i);
            price += item.getPrice();
        }
        return price;
    }

    public String orderDescription(){
        return "The order is " + payment.pay(price) + " and " + delivery.delivery(items);
    }
    public void processOrder(){
        System.out.println("I am processing");
        calculateTotalPrice();
        payment.pay(price);
        delivery.delivery(this.items);
        System.out.println("Thanks for your purchase");
        }
}
