package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class CompletedState implements RequestState {
    private Request _request;

    public CompletedState(Request request) {
        this._request = request;
    }

    @Override
    public void stateAction() {
        System.out.println("Request is completed");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        //Notify, proceed payment
    }

    public String getDescription() {
        return "Completed";
    }
}
