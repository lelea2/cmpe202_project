package Pricing;

import Membership.Membership;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingByDistance implements PricingStrategy {

    private final static double PRICE_PER_MILE = 1.0;
    private final static double DISTANCE = 100;
    @Override
    public double pricing(Membership membership) {
        return DISTANCE*PRICE_PER_MILE*PricingByMembership.getMemberPrice(membership);
    }
}
