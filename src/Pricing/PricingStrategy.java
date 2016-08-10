package Pricing;


import Membership.Membership;

/**
 * Created by kdao on 7/22/16.
 */
public interface PricingStrategy {
    public double pricing(Membership membership);
}
