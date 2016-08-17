package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class CancelledState implements RequestState {
    private Request _request;

    public CancelledState(Request request) {
        this._request = request;
        stateAction();
    }

    @Override
    public void stateAction() {
        System.out.println("Request is cancelled");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        //Notify
    }

    public String getDescription() {
        return "cancelled";
    }
}
