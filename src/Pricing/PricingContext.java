package Pricing;

import Membership.Customer;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingContext {
    protected PricingStrategy pricingStrategy;

    //int traffic_status;//0(good traffic),1(bad traffic),2(Rain day)


    public double processPricing(int traffic_status, Customer membership) {
        PricingStrategy pricingStrategy = setPricingStrategy(traffic_status);
        return pricingStrategy.pricing(membership);
    }

    public PricingStrategy setPricingStrategy(int traffic_status) {

        if((traffic_status == 0)){
            pricingStrategy = new PricingByDistance();
        }else if(traffic_status == 1){
            pricingStrategy = new PricingByTime();
        }else if(traffic_status == 2){
            pricingStrategy = new PricingByWeather();
        }

        return pricingStrategy;

    }
}
