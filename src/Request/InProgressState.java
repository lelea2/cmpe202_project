package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class InProgressState implements RequestState {
    private Request _request;

    public InProgressState(Request request) {
        this._request = request;
    }

    @Override
    public void stateAction() {
        System.out.println("Request is Processing");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        this._request.setState(new CompletedState(this._request));
    }

    public String getDescription() {
        return "Processing";
    }
}
