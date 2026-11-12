package strategy;

public class UpiPaymentStrategy implements PaymentStrategy{
    private final String upiId;

    UpiPaymentStrategy(String upiId){
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing UPI payment of amount " + amount + " via upi ID "  + upiId);
        return true;
    }
}

