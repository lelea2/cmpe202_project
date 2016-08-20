package Pricing;


import Membership.*;
import Schedule.*;

/**
 * Created by kdao on 7/22/16.
 */
public interface PricingStrategy {
    public double getPricing(Schedule s);
}
