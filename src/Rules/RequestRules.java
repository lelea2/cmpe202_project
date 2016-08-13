package Rules;

import java.awt.*;

import Membership.GoldMembershipDecorator;
import Membership.MembershipDecorator;
import Membership.SilverMembershipDecorator;
import Request.*;

/**
 * Created by kdao on 8/7/16.
 */
public class RequestRules {
    private Request _request;
    private int xMax = 50;
    private int yMax = 50;

    public RequestRules(Request request) {
        this._request = request;
    }

    /**
     * Check rule set for accepting request
     */
    public void checkRules() {
        checkCustomerBenefits();
        if(requestExceedTravelRange()) {
            this._request.setState(new RejectedState(this._request)); //notify for rejected state
        } else {
            this._request.setState(new PendingState(this._request)); //scheduling in detail
        }
    }

    public void checkCustomerBenefits() {
        if (_request.getUser() instanceof GoldMembershipDecorator || _request.getUser() instanceof SilverMembershipDecorator) {
            ((MembershipDecorator) _request.getUser()).checkBenefits();
            System.out.println("------------------------------------------------------");
        }
    }

    /**
     * Return true if request exceed travel range
     * @return
     */
    public boolean requestExceedTravelRange() {
        Point startPoint = this._request.getStartPoint();
        Point endPoint = this._request.getEndPoint();

        int xDist = Math.abs(endPoint.x - startPoint.x);
        int yDist = Math.abs(endPoint.y - startPoint.y);

        if(xDist > xMax || yDist > yMax) {
            System.out.println("Warning: Exceeded travel range, choose a shorter destination");
            return true;
        }
        return false;
    }
}
