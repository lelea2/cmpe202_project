package Schedule;

import Feedback.*;
import Membership.*;
import Report.*;
import Vehicle.*;
import Parking.*;

import java.util.*;

/**
 * Created by kdao on 8/13/16.
 */
public class SchedulePayState implements ScheduleState {
    private Schedule _schedule;
    private Parking parking = new Parking();
    private ArrayList<Integer> avalList = parking.getAvailableSlots();
    Scanner input = new Scanner(System.in);

    public SchedulePayState(Schedule s) {
        System.out.println("Schedule in paid state.");
        _schedule = s;
        findParkingSpot();
        freeVehicle(); //free vehicle state
        updateCustomer();
        //TODO: asking for feedback here
        generateFeedback();
    }

    public void queuing() {
        System.out.println("Cannot queue schedule that already paid.");
    }

    public void approve() {
        System.out.println("Cannot approve schedule that already paid.");
    }
    public void start() {
        System.out.println("Cannot start schedule that already paid.");
    }
    public void complete() {
        System.out.println("Cannot pay schedule that already paid.");
    }
    public void pay() {
        System.out.println("Cannot pay schedule that already paid");
    }
    public void cancel() {
        System.out.println("Cannot complete schedule that already paid");
    }

    //Function to generate feedback
    public void generateFeedback() {
        //TODO: adding feebdback class here
        System.out.println("Please leave your feedback: (Y/N)");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            Report report;
            Feedback fb = null;
            System.out.println("Feedback type: 1 - For Driver, 2 - For Pricing, 3 - For overall service");
            int type = Integer.parseInt(input.nextLine());
            System.out.println("Feedback title:");
            String title = input.nextLine();
            System.out.println("Feedback Content:");
            String content = input.nextLine();
            System.out.println("Feedback Rating:");
            int rating = Integer.parseInt(input.nextLine());
            if (type == 1) { //
                fb = new DriverFeedback(title, content, rating);
                fb.provideFeedback();
            } else if (type == 2) {
                fb = new PricingFeedback(title, content, rating);
                fb.provideFeedback();
            } else if (type == 3) {
                fb = new ServiceFeedback(title, content, rating);
                fb.provideFeedback();
            } else {
                System.out.print("Not a valid option");
            }
            if (fb != null) { //Generate feebback report here
                report = new FeedbackReport(fb);
                report.printReport();
            }
        } else {
            System.out.println("Thank you, no feedback this time");
        }
    }

    //Function to find parking spot
    public void findParkingSpot() {
        //Calling parking here
        parking = parking.load();
        System.out.println(">>>>>>>>>>>>>>>>>>>> Pick available parking spot <<<<<<<<<<<<<<<<<");
        avalList = parking.getAvailableSlots();
        for (int i = 0; i < avalList.size(); i++) {
            System.out.print(avalList.get(i) + " - ");
        }
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.next());
        if (parking.enterParkingSlot(choice)) {
            System.out.println("Car has enter parking #" + choice);
        } else {
            System.out.println("Parking is not currently available");
        }
    }

    //Function to free up vehicle
    public void freeVehicle() {
        System.out.println(">>>>>>>> Free up vehicle <<<<<<<<<<<<<");
        Vehicle v = _schedule.get_vehicleAndDriver().getVehicle();
        v.setVehicleState(new VehicleFreeState(v));
        v.setLocation(_schedule.get_request().getEndPoint());
        _schedule.get_vehicleAndDriver().getVehicle().getState().free();
    }

    //Function to update customer state
    public void updateCustomer() {
        if (_schedule.get_request().getUser() instanceof Customer) {
            System.out.println(">>>>>>>>>> Update customer's ride <<<<<<<<<<<<<<<<<<");
            ((Customer) _schedule.get_request().getUser()).addRide();
            ((Customer) _schedule.get_request().getUser()).addMileages(_schedule.getDistance());
            System.out.println(">>>>>>>>>>>>>>> Result <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Total Ride: " + ((Customer) _schedule.get_request().getUser()).get_rides());
            System.out.println("Total Mileages: " + ((Customer) _schedule.get_request().getUser()).get_mileages());
        }
    }

    public String getState() {
        return "Pay";
    }
}
