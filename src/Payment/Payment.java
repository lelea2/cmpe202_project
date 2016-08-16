package Payment;

/**
 * Created by kdao on 7/22/16.
 */
public abstract class Payment {
    protected double _paymentAmount ;
    protected String _payerName ;
    protected boolean _paymentSucceeded ;

    /**
     * Function helper proceed to complete a transaction
     */
    public void completeTransaction() {
        _paymentSucceeded = false;
        while ( !_paymentSucceeded ) {
            setupPayment();
            processPayment();
        }
        printReceipt();
    }

    abstract public void setupPayment();
    abstract public void processPayment();
    abstract public void printReceipt();

    public void set_paymentAmount(double amt) {
        _paymentAmount = amt ;
    }

    public double get_paymentAmount() {
        return _paymentAmount ;
    }

    public void set_payerName(String name) {
        _payerName = name;
    }

    public String get_payerName() {
        return _payerName;
    }

    public String getPaymentStatus() {
        if (_paymentSucceeded == true) {
            return "Succeed";
        } else {
            return "Failed";
        }
    }
}
