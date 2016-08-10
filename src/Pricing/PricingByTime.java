package Pricing;

import Membership.Membership;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingByTime implements PricingStrategy{

    private final static double PRICE_PER_MINUTE = 0.05;
    private final static double TIME = 20;
    @Override
    public double pricing(Membership membership) {
        return TIME*PRICE_PER_MINUTE*PricingByMembership.getMemberPrice(membership);
    }
}
