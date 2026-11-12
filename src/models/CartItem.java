package models;

import util.UniqueIdGenerator;

public class CartItem {
    private final String id;

    private final Product product;

    private final double priceWhenAdded;

    private int quantity;

    CartItem(Product product, double priceWhenAdded, int initialQuantity){
        this.id = UniqueIdGenerator.getUniqueId();
        this.product = product;
        this.priceWhenAdded = priceWhenAdded;
        this.quantity = initialQuantity;
    }

    public String getId(){
        return this.id;
    }

    public Product getProduct(){
        return this.product;
    }

    public void updateQuantity(int newQuantity){
        if(newQuantity < 0){
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if(newQuantity == quantity){
            throw new IllegalArgumentException("Please choose different quantity then current!");
        }
        this.quantity = newQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubTotal(){
        return 1.00 * quantity * priceWhenAdded;
    }


}
