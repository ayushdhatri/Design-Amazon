package services;

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

    public void updateStockForOrder(List<OrderLineItem> items){

    }

    public void restock(List<OrderLineItem> items){

    }


}
