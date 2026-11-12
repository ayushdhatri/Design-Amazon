import models.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingCart {
    private final Map<String, Customer> customers = new ConcurrentHashMap<>();



    public Customer registerCustomer(String name, String username, String password,
                                     Address address){
        Account account = new Account(username, password);
        Customer customer = new Customer(name, address, account);
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Cart getCustomerCart(String customerId){
        Customer customer = customers.get(customerId);
        return customer.getAccount().getCart();
    }

    public void addProductToCart(String customerId, Product product, int quantity){
        Customer customer = customers.get(customerId);
        customer.getAccount().getCart().updateCartItemQuantity();

    }



}
