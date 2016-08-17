package Request;

import Notifications.*;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class CancelledState implements RequestState {
    private Request _request;
    private Notifications notifications;

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
        notifications = new Notifications(1, "Your request has been cancel", "Cancel request");
        notifications.addObserver(_request.getUser());
        notifications.sendNotification(); //complete state and send notification
    }

    @Override
    public String getDescription() {
        return "cancelled";
    }
}
