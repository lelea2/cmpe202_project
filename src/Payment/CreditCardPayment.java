package Payment;

import java.util.Scanner;

/**
 * Created by kdao on 8/7/16.
 */
public class CreditCardPayment extends Payment {
    private String _ccNumber;
    private String _ccExpiration;
    private String _ccSecurecode;

    public CreditCardPayment(String payerName) {
        _payerName = payerName ;
    }

    @Override
    public void setupPayment() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Card number:");
        _ccNumber = scan.next();
        System.out.println("Card exp (MM/YY):");
        _ccExpiration = scan.next();
        System.out.println("Card secure code:");
        _ccSecurecode = scan.next();
        System.out.println("Card information validated. Beginning Transaction...");
    }

    @Override
    public void processPayment() {
        _paymentSucceeded = true ;
    }

    @Override
    public void printReceipt() {
        System.out.format("Paid $%.2f\n", _paymentAmount);
    }
}
