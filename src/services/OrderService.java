package services;

import enums.OrderStatus;
import models.Cart;
import models.Customer;
import models.Order;
import models.OrderLineItem;

import java.util.List;

public class OrderService {
    private final InventoryService inventoryService;


    public OrderService(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Customer customer, Cart cart){
        // collect all items from cart
        // update the inventory
        List<OrderLineItem> items = cart.getCartItems().stream().map(cartItem -> {
            return new OrderLineItem(cartItem.getProduct().getId(), cartItem.getProduct().getName(), cartItem.getQuantity(), cartItem.getSubTotal());
        }).toList();

        inventoryService.updateStockForOrder(items);

        return new Order(customer, items,customer.getShippingAddress(),cart.getTotal());

    }
}
