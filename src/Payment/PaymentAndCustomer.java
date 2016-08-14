package Payment;

import Membership.*;

/**
 * Created by kdao on 8/14/16.
 */
//Maintain membership payment registration
public class PaymentAndCustomer {
    private Payment payment;
    private Customer customer;

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
