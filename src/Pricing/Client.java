package Pricing;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class Client {
    public static void main(String [] args){
        int traffic_status = 2;
        PricingContext pricingContext = new PricingContext();
        System.out.println(pricingContext.pricing(traffic_status));
    }
}
