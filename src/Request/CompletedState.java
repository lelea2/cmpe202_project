package Request;

import Notifications.*;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class CompletedState implements RequestState {
    private Request _request;
    private Notifications notifications;

    public CompletedState(Request request) {
        this._request = request;
        stateAction();
    }

    @Override
    public void stateAction() {
        System.out.println("Request is completed");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        //Notify
        notifications = new Notifications(1, "Your request has been approved", "Complete request");
        notifications.addObserver(_request.getUser());
        notifications.sendNotification(); //complete state and send notification
    }

    public String getDescription() {
        return "Completed";
    }
}
