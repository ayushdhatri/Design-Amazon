package models;

import enums.OrderStatus;
import states.OrderState;
import states.PlacedState;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private final String id;

    private final Customer customer;

    private final List<OrderLineItem> items;

    private final double totalAmount;

    private final Address shippingAddress;

    private final LocalDateTime orderDate;

    private OrderStatus status;

    private OrderState state;

    public Order(Customer customer, List<OrderLineItem> items, Address shippingAddress, double totalAmount) {
        this.id = "ORD-1001";
        this.customer = customer;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PLACED;
        this.state = new PlacedState();
    }

    public void shipOrder(){
        state.ship(this);

    }

    public void deliverOrder(){
        state.deliver(this);
    }

    public void cancelOrder(){
        state.cancel(this);
    }

    // Getters and Setters
    public String getId() { return id; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setOrderState(OrderState state){
        this.state = state;
    }
    public List<OrderLineItem> getItems() { return items; }









}
