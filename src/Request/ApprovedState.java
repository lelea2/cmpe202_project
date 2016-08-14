package Request;

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
    }

    @Override
    public void goToNextState() {
        this._request.setState(new InProgressState(this._request));
    }

    public String getDescription() {
        return "Approved";
    }
}
