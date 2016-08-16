package Pricing;


import Membership.Customer;

/**
 * Created by kdao on 7/22/16.
 */
public interface PricingStrategy {
    public double pricing(Customer customer);
}
