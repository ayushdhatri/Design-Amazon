package exception;

public class OutOfStock extends RuntimeException{

    public OutOfStock(String productId, Integer quantity){
        super("Not enough stock for product Id  " + productId);
    }
}
