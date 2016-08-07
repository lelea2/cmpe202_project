package Payment;

import java.util.Scanner;

/**
 * Created by kdao on 8/7/16.
 */
public class CreditCardPayment extends Payment {
    private String _ccNumber;
    private String _ccExpiration;

    public CreditCardPayment(String payerName) {
        _payerName = payerName ;
    }

    @Override
    public void setupPayment() {
        Scanner scan = new Scanner(System.in);
        _ccNumber = scan.next();
        _ccExpiration = scan.next();}

    @Override
    public void processPayment() {
        _paymentSucceeded = true ;
    }

    @Override
    public void printReceipt() {
    }
}
