package Report;

import Payment.*;

/**
 * Created by LeonZhang on 8/10/16.
 */
public class PaymentReport extends Report {
    private Payment payment;
    private String type;

    public PaymentReport(Payment payment, String type) {
        this.payment = payment;
        this.type = type;
        set_description("Payment Report");
    }

    public void printReport(){
        System.out.println("\n" + _description);
        System.out.println("=====================================================================");
        System.out.println("Type  : " + type);
        System.out.format("Amount : $%.2f\n", payment.get_paymentAmount());
        System.out.println("Status: " + payment.getPaymentStatus());
        System.out.println("=====================================================================\n");
    }
}
