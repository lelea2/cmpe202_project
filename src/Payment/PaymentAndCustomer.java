package Payment;

import Membership.*;

/**
 * Created by kdao on 8/14/16.
 */
//Maintain membership payment registration
public class PaymentAndCustomer {
    private CreditCardPayment payment;
    private Customer customer;

    public PaymentAndCustomer(CreditCardPayment payment, Customer customer) {
        this.payment = payment;
        this.customer = customer;
    }

    public CreditCardPayment getPayment() {
        return payment;
    }
    public void setPayment(CreditCardPayment payment) {
        this.payment = payment;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
