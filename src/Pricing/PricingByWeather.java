package Pricing;

import Membership.*;
import Schedule.*;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class PricingByWeather implements PricingStrategy {

    @Override
    public double getPricing(Schedule s) {
        //TODO: implement pricing here based on bad/good weather
        return 10 * PricingByMembership.getMemberPrice((Customer)s.get_request().getUser());
    }
    //Still keeping price by time then make double price;
}
