package Pricing;

import Membership.*;
import Schedule.*;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingByDistance implements PricingStrategy {

    private final static double PRICE_PER_MILE = 1.0;
//    private final static double DISTANCE = 100;

    @Override
    public double getPricing(Schedule s) {
        System.out.println("Time Pricing $1.0/minute");
        return s.getDistance() * PRICE_PER_MILE * PricingByMembership.getMemberPrice((Customer)s.get_request().getUser());
    }
}
