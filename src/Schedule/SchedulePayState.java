package Schedule;

import Membership.*;
import Vehicle.*;
import Parking.*;

/**
 * Created by kdao on 8/13/16.
 */
public class SchedulePayState implements ScheduleState {
    private Schedule _schedule;
    private Parking parking = new Parking(10);

    public SchedulePayState(Schedule s){
        System.out.println("Schedule in paid state.");
        _schedule = s;
        findParkingSpot();
        freeVehicle(); //free vehicle state
        updateCustomer();
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

    //Function to find parking spot
    public void findParkingSpot() {
        //Calling parking here
    }

    //Function to free up vehicle
    public void freeVehicle() {
        Vehicle v = _schedule.get_vehicleAndDriver().getVehicle();
        v.setVehicleState(new VehicleFreeState(v));
        v.setLocation(_schedule.get_request().getEndPoint());
        _schedule.get_vehicleAndDriver().getVehicle().getState().free();
    }

    //Function to update customer state
    public void updateCustomer() {
        if (!(_schedule.get_request().getUser() instanceof Driver)){
            ((Customer) _schedule.get_request().getUser()).addRide();
            ((Customer) _schedule.get_request().getUser()).addMileages(_schedule.getDistance());
        }
    }

    public String getState() {
        return "Pay";
    }
}
