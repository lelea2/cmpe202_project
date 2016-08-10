package Payment;

/**
 * Created by kdao on 8/7/16.
 */
public class CashPayment extends Payment {
    public CashPayment(String payerName) {
        _payerName = payerName ;
    }

    @Override
    public void setupPayment() {
        System.out.println("Driver has indicated cash payment method");
    }

    @Override
    public void processPayment() {
        System.out.format("Customer %s paid cash in the amount of $%.2f for services\n", _payerName, _paymentAmount);
        _paymentSucceeded = true ;
    }

    @Override
    public void printReceipt() {
    }
}
