package Pricing;

import Membership.*;
import Schedule.Schedule;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingContext {
    protected PricingStrategy pricingStrategy;

    //Default constructor
    public PricingContext() {}

    public double getPrice(Schedule _schedule) {
        double price ;
        pricingStrategy = setPricingStrategy(_schedule) ;
        price = pricingStrategy.getPricing(_schedule);
        return price;
    }

    public PricingStrategy setPricingStrategy(Schedule schedule) {
        String currStrategy = "Time";
        if (schedule.getDistance() > schedule.getTotalTime()/2) { //set current by Distance
            currStrategy = "Distance";
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Pricing strategy setting, distance=" + schedule.getDistance() + "; totalTime=" + schedule.getTotalTime());
        System.out.println("Strategy used: " + currStrategy);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        if (currStrategy.equals("Time")) {
            return new PricingByTime();
        } else if (currStrategy.equals("Weather")) { //TODO: check for weather, right now we don't maintain this logic in schedule object
            return new PricingByWeather();
        } else { //Default PricingStrategy is Distance
            return new PricingByDistance();
        }
    }

}
