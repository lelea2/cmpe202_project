package Pricing;

import Membership.*;
import Schedule.*;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingByTime implements PricingStrategy {

    private final static double PRICE_PER_MINUTE = 0.5;
//    private final static double TIME = 20;

    @Override
    public double getPricing(Schedule s) {
        System.out.println("Time Pricing $0.5/minute");
        return s.getTotalTime() * PRICE_PER_MINUTE * PricingByMembership.getMemberPrice((Customer)s.get_request().getUser());
    }
}
