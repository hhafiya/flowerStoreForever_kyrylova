package com.flower.flowerсontinue.order;

import java.util.List;

import com.flower.flowerсontinue.delivery.Delivery;
import com.flower.flowerсontinue.flower.Flower;
import com.flower.flowerсontinue.flower.Item;
import com.flower.flowerсontinue.payment.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private int orderId;
    private List<Item> items;
    private Payment payment;
    private Delivery delivery;
    
    public void setPaymentStrategy(Payment paymentSrategy) {
        payment = paymentSrategy;
    }
    public void setDeliveryStrategy(Delivery deliverySrategy) {
        delivery = deliverySrategy;
    }

    public void addItem(Flower item) {
        items.add(item);
    }

    public void removeItem(Flower item) {
        items.remove(item);
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void processOrder() {
        double sum = calculateTotalPrice();
        payment.pay(sum);
        delivery.deliver(items);
    }
}
