package Request;

/**
 * Created by kdao on 8/13/16.
 */
public class RejectedState implements RequestState {
    private Request _request;

    public RejectedState(Request request) {
        this._request = request;
    }

    @Override
    public void stateAction() {
        System.out.println("Request is rejected");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        //Notify for rejected state
    }

    public String getDescription() {
        return "Rejected";
    }
}
