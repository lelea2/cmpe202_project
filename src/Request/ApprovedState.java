package Request;

import java.util.Scanner;
import Membership.*;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class ApprovedState implements RequestState {

    private Request _request;
    private Scanner scanner = new Scanner(System.in);

    public ApprovedState(Request request) {
        this._request = request;
        stateAction();
    }

    @Override
    public void stateAction() {
        System.out.println("Request is validated and approved");
        if(_request.getUser() instanceof Driver) {
            System.out.println("Driver pick up, ok? Y/N");
        } else {
            System.out.println("Request approved, start scheduling? Y/N");
        }
        String opt = scanner.next();
        if (opt.equalsIgnoreCase("y")) {
            goToNextState();
        } else {
            System.out.println("Rejected scheduling request....");
            this._request.setState(new CancelledState(this._request));
        }
    }

    @Override
    public void goToNextState() {
        System.out.println("Start scheduling...");
        this._request.setState(new SchedulingState(this._request));
    }

    @Override
    public String getDescription() {
        return "Approved";
    }
}
