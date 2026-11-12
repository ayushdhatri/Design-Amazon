package models;

import java.util.List;
import java.util.UUID;

public class Account {
    private final String id;

    private final String username;

    private final String password;

    private final Cart cart;

    private List<Order> orderHistory;

    Account(String username, String password){
        this.id = UUID.randomUUID().toString().substring(0,8);
        this.username = username;
        this.password = password;
        cart = new Cart();
    }

    public void addOrder(Order order){
        this.orderHistory.add(order);
    }

    public List<Order> getOrderHistory(){
        return this.orderHistory;
    }

    public Cart getCart(){
        return this.cart;
    }

}
