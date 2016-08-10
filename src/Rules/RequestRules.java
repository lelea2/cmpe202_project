package Rules;

import java.awt.*;

/**
 * Created by kdao on 8/7/16.
 */
public class RequestRules {
    /*private Request __request;

    public RequestRules(Request request) {
        this.__request = request;
    }

    public void checkRules() {
        checkCustomerBenefits();
        if(ExceedTravelRange()) {
            this.__request.setState(new RejectedState(this.__request));
        } else {
            this.__request.setState(new SchedulingState(this.__request));
        }
    }

    public void checkCustomerBenefits() {
        if (__request.getUser() instanceof BronzeDecorator || __request.getUser() instanceof SilverDecorator ||
                __request.getUser() instanceof GoldDecorator) {
            ((CustomerLoyaltyDecorator) __request.getUser()).checkBenefits();
            System.out.println("======================");
        }
    }

    public boolean ExceedTravelRange() {
        Point startPoint = this.__request.getStartPoint();
        Point endPoint = this.__request.getEndPoint();

        int xDist = Math.abs(endPoint.x - startPoint.x);
        int yDist = Math.abs(endPoint.y - startPoint.y);

        if(xDist > 20 || yDist > 20) {
            System.out.println("Exceeded travel range, choose a shorter destination!!!");
            return true;
        }
        return false;
    }*/
}
