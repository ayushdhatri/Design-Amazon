package services;

import exception.OutOfStock;
import models.Order;
import models.OrderLineItem;
import models.Product;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    private final Map<String, Integer> stock;

    public InventoryService(){
        this.stock = new ConcurrentHashMap<>();
    }

    public void addStock(Product product, int quantity){
        this.stock.put(product.getId(), stock.getOrDefault(product.getId(), 0) + quantity);
    }

    public synchronized void updateStockForOrder(List<OrderLineItem> items){
        // here we will verify each item and its
        for(OrderLineItem item : items){
            Integer inventoryQuantity = stock.getOrDefault(item.getProductId(), 0);
            if(item.getQuantity() < inventoryQuantity){
                throw new OutOfStock(item.getProductId(), item.getQuantity());
            }
        }
        // Here we can say that all items are present , so update the quantity
        for(OrderLineItem item : items){
            int newQuantity = stock.get(item.getProductId()) - item.getQuantity();
            stock.put(item.getProductId(), newQuantity);
        }


    }

    public synchronized void restock(List<OrderLineItem> items){
        for(OrderLineItem item : items){
            stock.put(item.getProductId(), stock.get(item.getProductId()) + item.getQuantity());
        }
    }


}
