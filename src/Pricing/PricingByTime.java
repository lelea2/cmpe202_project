package Pricing;

import Membership.Customer;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingByTime implements PricingStrategy{

    private final static double PRICE_PER_MINUTE = 0.05;
    private final static double TIME = 20;
    @Override
    public double pricing(Customer membership) {
        return TIME * PRICE_PER_MINUTE * PricingByMembership.getMemberPrice(membership);
    }
}
