package Pricing;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingByDistance implements PricingStrategy {

    private final static double PRICE_PER_MILE = 1.0;
    private final static double distance = 100;
    @Override
    public double pricing() {
        return distance*PRICE_PER_MILE;
    }
}
