package Rules;

import java.awt.*;
import Request.*;

/**
 * Created by kdao on 8/7/16.
 */
//Validating request rules
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
        if(requestExceedTravelRange()) {
            this._request.setState(new RejectedState(this._request)); //notify for rejected state
        } else {
            this._request.setState(new ApprovedState(this._request)); //validating request and approve it
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
