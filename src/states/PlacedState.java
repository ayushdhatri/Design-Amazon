package states;

import enums.OrderStatus;
import models.Order;

public class PlacedState implements OrderState{

    @Override
    public void ship(Order order) {
        System.out.println("Shipping order " + order.getId());
        order.setStatus(OrderStatus.SHIPPED);
        order.setOrderState(new ShippedState());
    }

    @Override
    public void deliver(Order order) {

    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelling order " + order.getId());
        order.setStatus(OrderStatus.CANCELLED);
        order.setOrderState(new CancelledState());


    }
}
