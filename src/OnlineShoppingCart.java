import exception.OutOfStock;
import models.*;
import services.InventoryService;
import services.OrderService;
import services.PaymentService;
import strategy.PaymentStrategy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingCart {
    private final Map<String, Customer> customers = new ConcurrentHashMap<>();

    private final Map<String, Product> products = new ConcurrentHashMap<>();

    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    private final InventoryService inventoryService;

    private final OrderService orderService;

    private final PaymentService paymentService;

    public OnlineShoppingCart(){
        this.inventoryService = new InventoryService();
        this.orderService = new OrderService(inventoryService);
        this.paymentService = new PaymentService();
    }

    public void addProductToInventory(Product product, int intialStock){
        this.inventoryService.addStock(product, intialStock);
        this.products.put(product.getId(), product);
        System.out.println("Product added to inventory");
    }

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
        customer.getAccount().getCart().updateCartItemQuantity(product, quantity);
    }

    public Order placeOrder(String customerId, PaymentStrategy paymentStrategy){
        // get the customer cart first
        Cart cart = customers.get(customerId).getAccount().getCart();
        List<CartItem> cartItemList = cart.getCartItems();

        // Ask the price and payment strategy
        Order order;
        try{
            order = orderService.createOrder(customers.get(customerId),cart);
        }
        catch (OutOfStock e){
            System.out.println("Order placement failed " + e.getMessage());
            return null;
        }

        boolean isPaymentSuccess = paymentService.processPayment(paymentStrategy, cart.getTotal());
        if(!isPaymentSuccess){
           inventoryService.restock(order.getItems());
           System.out.println("payment failed. Please try again later");
           return null;
        }

        orders.put(order.getId(), order);
        cart.clearCart();
        return order;









    }





}
