package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class PendingState implements RequestState {
    private Request _request;

    public PendingState(Request request) {
        this._request = request;
        stateAction();
    }

    @Override
    public void stateAction() {
        System.out.println("Request is pending");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        //Ask for state of scheduling, when request is pending to wait for approval
        System.out.println("********* Validating request..................");
        this._request.requestRules.checkRules();
    }

    public String getDescription() {
        return "Pending";
    }
}
