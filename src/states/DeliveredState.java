package states;

import models.Order;

public class DeliveredState implements OrderState {
    @Override
    public void ship(Order order) {
        System.out.println("order is already shipped");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Order is already delivered");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel a delivered order.");
    }
}
