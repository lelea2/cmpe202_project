package Feeback;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class Client {
    public static void main(String[] args){
        ServiceFeedback serviceFeedback = new ServiceFeedback("1","A",1);
        DriverFeedback driverFeedback = new DriverFeedback("2", "B", 2);
        PricingFeedback pricingFeedback = new PricingFeedback("3", "C", 3);
        serviceFeedback.provideFeedback();
        driverFeedback.provideFeedback();
        pricingFeedback.provideFeedback();
    }
}
