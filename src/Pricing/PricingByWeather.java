package Pricing;

import Membership.Membership;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class PricingByWeather implements PricingStrategy{
    @Override
    public double pricing(Membership membership) {
        return new PricingByTime().pricing(membership)*2;
    }
    //Still keeping price by time then make double price;
}
