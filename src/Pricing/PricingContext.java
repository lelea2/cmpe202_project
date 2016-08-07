package Pricing;

/**
 * Created by kdao on 7/24/16.
 */
public class PricingContext {
    protected PricingStrategy _pricingStrategy;

    public PricingContext() {

    }

    public float getPrice(Service _service) {
        float price ;
        _pricingStrategy = setPricingStrategy(_service) ;
        price = _pricingStrategy.getPrice(_service);
        return price ;
    }

    public PricingStrategy setPricingStrategy(Service _service) {
        String strategy = "Time" ;

        if (_service.getDistanceInMiles() > _service.getTotalTimeInMinutes()/2) {
            strategy = "Distance";
        }

        if (strategy.equals("Demand")) {
            return new PriceByDemand() ;
        } else if (strategy.equals("Time")) {
            return new PriceByTime() ;
        } else if (strategy.equals("Distance")) {
            return new PriceByDistance() ;
        } else {
            //Default PricingStrategy is Distance
            return new PriceByDistance() ;
        }
    }
}
