package Request;

import java.util.Scanner;
import Payment.*;
import Schedule.*;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class SchedulingState implements RequestState {
    private Request _request;
    private Scanner scan = new Scanner(System.in);

    public SchedulingState(Request request) {
        this._request = request;
        stateAction();
    }

    @Override
    public void stateAction() {
        System.out.println("Request is scheduling");
        goToNextState();
    }

    @Override
    public void goToNextState() {
        System.out.println("Request validated, now add to schedule...");
        int paymentType;
        Payment payment = null;
        while(payment == null) {
            System.out.println("Pay for service: 1 - Credit Card, 2 - Cash");
            try {
                paymentType = Integer.parseInt(scan.next());
                if (paymentType == 2) { //Cash payment
                    payment = new CashPayment(_request.getUser().get_name());
                } else if (paymentType == 1) { //Credit card payment
                    payment = new CreditCardPayment(_request.getUser().get_name());
                } else {
                    System.out.println("Invalid input, please try again, value must be either 1 or 2");
                }
            } catch(Exception e) {
                System.out.println("Invalid input, please try again, value must be either 1 or 2");
            }
        }
        System.out.println("Request is creating new Service");
        // Set new service with current request, to the current request
        this._request.setSchedule(new ScheduleRide(this._request, payment)); //Create ride, which is extends of Schedule for adding object
        if(this._request.getSchedule().get_scheduleState().getState().equalsIgnoreCase("approve")) {
            //goToNextState();
            System.out.println("Schedule already approved. No need to approve again");
        } else {
            System.out.println("Schedule is created and is queued waiting for resources");
        }
        this._request.setState(new CompletedState(this._request));
    }

    @Override
    public String getDescription() {
        return "Scheduling...";
    }
}
