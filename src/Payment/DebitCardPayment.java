package Payment;

import java.util.Scanner;

/**
 * Created by kdao on 8/9/16.
 */
public class DebitCardPayment extends Payment {
    private String _ccNumber;
    private String _ccExpiration;
    private String _ccSecurecode;

    public DebitCardPayment(String payerName) {
        _payerName = payerName ;
    }

    @Override
    public void setupPayment() {
        Scanner scan = new Scanner(System.in);
        _ccNumber = scan.next();
        _ccExpiration = scan.next();
        _ccSecurecode = scan.next();
    }

    @Override
    public void processPayment() {
        _paymentSucceeded = true ;
    }

    @Override
    public void printReceipt() {
    }
}
