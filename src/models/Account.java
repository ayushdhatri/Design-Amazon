package models;

import java.util.List;

public class Account {
    private final String id;

    private List<Order> orderHistory;

    Account(String id){
        this.id = id;
    }

    public void addOrder(Order order){
        this.orderHistory.add(order);
    }

    public List<Order> getOrderHistory(){
        return this.orderHistory;
    }

}
