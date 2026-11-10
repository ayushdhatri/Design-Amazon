package models;

import enums.OrderStatus;

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




    public Order(Customer customer, List<OrderLineItem> items, Address shippingAddress, double totalAmount) {
        this.id = "ORD-1001";
        this.customer = customer;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PLACED;

    }

    // Getters and Setters
    public String getId() { return id; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) {
        // TODO: Update the order status and tell the observers.
        // Store the new status on the order.
        // Then notify the observers so the customer gets the update.
    }
    public List<OrderLineItem> getItems() { return items; }









}
