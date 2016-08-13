package Pricing;

import Membership.Customer;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class PricingByWeather implements PricingStrategy{
    @Override
    public double pricing(Customer membership) {
        return new PricingByTime().pricing(membership)*2;
    }
    //Still keeping price by time then make double price;
}
