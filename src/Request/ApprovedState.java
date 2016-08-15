package Request;

import java.util.Scanner;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class ApprovedState implements RequestState {

    private Request _request;

    public ApprovedState(Request request) {
        this._request = request;
        stateAction();
    }

    @Override
    public void stateAction() {
        System.out.println("Request is Approved");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        System.out.println("Request is Validated, now scheduling...");
    }

    public String getDescription() {
        return "Approved";
    }
}
