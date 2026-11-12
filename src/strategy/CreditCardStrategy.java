package strategy;

public class CreditCardStrategy implements PaymentStrategy {

    private final String cardNumber;

    CreditCardStrategy(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of amount " + amount + " done successfully via credit card " + cardNumber);
        return true;
    }

}
