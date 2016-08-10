package Pricing;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingByTime implements PricingStrategy{

    private final static double PRICE_PER_MINUTE = 0.05;
    private final static double time = 20;
    @Override
    public double pricing() {
        return time*PRICE_PER_MINUTE;
    }
}
