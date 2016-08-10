package Pricing;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class PricingByWeather implements PricingStrategy{
    @Override
    public double pricing() {
        return new PricingByTime().pricing()*2;
    }
    //Still keeping price by time then make double price;
}
