package Report;

import Payment.*;

/**
 * Created by LeonZhang on 8/10/16.
 */
public class PaymentReport extends Report {
    private Payment payment;
    public PaymentReport(Payment payment){
        this.payment = payment;
        set_description("Payment Report");
    }

    public void printReport(){
        this.printReport();
    }
}
