package services;

import strategy.PaymentStrategy;

public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService(){

    }

    public boolean processPayment(PaymentStrategy strategy, double amount){
        if(amount < 0 ){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        return strategy.pay(amount);
    }


}
