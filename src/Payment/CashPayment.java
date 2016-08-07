package Payment;

/**
 * Created by kdao on 8/7/16.
 */
public class CashPayment extends Payment {
    public CashPayment(String payerName) {
        _payerName = payerName ;
    }

    @Override
    public void setupPayment(){
    }

    @Override
    public void processPayment() {
        _paymentSucceeded = true ;
    }

    @Override
    public void printReceipt() {

    }
}
