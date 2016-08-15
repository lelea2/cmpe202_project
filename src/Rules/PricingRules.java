package Rules;

import Pricing.PricingStrategy;

/**
 * Created by kdao on 8/7/16.
 */
//Set rules for pricing travel
public class PricingRules implements Rules{
    protected float _pricingPerMile;
    protected float _pricingPerMinute;

    //Constructor
    public PricingRules() {
        _pricingPerMile = 2.00f;
        _pricingPerMinute = 2.50f ;
    }

    @Override
    public void getRules() {
    }

    public float getPricePerMile() {
        return _pricingPerMile ;
    }

    public float getPricePerMinute() {
        return _pricingPerMinute ;
    }
}
