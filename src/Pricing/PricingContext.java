package Pricing;

import Membership.*;
import Schedule.Schedule;

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
        if((traffic_status == 0)) {
            pricingStrategy = new PricingByDistance();
        } else if(traffic_status == 1) {
            pricingStrategy = new PricingByTime();
        } else if(traffic_status == 2) { //TODO: right now schedule does not have weather, set up later
            pricingStrategy = new PricingByWeather();
        }
        return pricingStrategy;
    }

    public double getPrice(Schedule schedule) {
        double price;
        int strategy  = 1; //By default set by time
        if (schedule.getDistance() > schedule.getTotalTime() / 2) {
            strategy = 0; //Get distance
        }
        pricingStrategy = setPricingStrategy(strategy);
        Member user = schedule.get_request().getUser();
        if (user instanceof Customer) {
            price = pricingStrategy.pricing((Customer) schedule.get_request().getUser());
        } else {
            price = 0.0; //If driver then don't charge
        }
        return price;
    }

}
