package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {
    private final String id;

    private final Map<String, CartItem> cartItems;

    Cart(){
        this.id = UUID.randomUUID().toString().substring(0,8);
        this.cartItems = new ConcurrentHashMap<>();
    }

    public String getId(){
        return this.id;
    }

    public List<CartItem> getCartItems(){
        return cartItems.values().stream().toList();
    }

    public synchronized void updateCartItemQuantity(CartItem cartItem, int newQuantity){
        if(cartItem == null){
            throw new IllegalArgumentException("CartItem cannot be null!");
        }

        if(cartItems.containsKey(cartItem.getId())){
            CartItem currentCartItem = cartItems.get(cartItem.getId());
            currentCartItem.updateQuantity(newQuantity);
            return;
        }
        cartItems.put(cartItem.getId(), cartItem);
    }

    public synchronized void removeItemFromCart(String cartItemId){
        CartItem cartItem = cartItems.get(cartItemId);
        if(cartItem == null){
            throw new IllegalArgumentException("Cart Item with id" + cartItemId + " does not exist");
        }
        cartItems.remove(cartItemId);
        System.out.println("Cart Item with id" + cartItemId + "remove successfully");
    }

    public double getTotal(){
        double totalPrice = 0.0;
        for(Map.Entry<String, CartItem> entry : cartItems.entrySet()){
            totalPrice += entry.getValue().getSubTotal();
        }
        return totalPrice;
    }




}
