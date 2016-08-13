package Vehicle;

/**
 * Created by kdao on 8/13/16.
 */
public class VehicleFinishState implements VehicleState {
    protected Vehicle _vehicle;

    public VehicleFinishState(Vehicle vehicle) {
        System.out.println("This vehicle is finish operating.");
        _vehicle = vehicle;
    }

    public void free() {
        System.out.println("This vehicle is available for next service. Go to free state");
    }

    public void schedule() {
        System.out.println("Vehicle is available for scheduled for service.");
    }

    public void operate() {
        System.out.println("Vehicle is NOT currently in operation operating.");
    }

    public void finish() {
        System.out.println("Already finish. Do not need to do anything");
    }
}
