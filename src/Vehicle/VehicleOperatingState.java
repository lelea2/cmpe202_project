package Vehicle;

/**
 * Created by kdao on 8/13/16.
 */
public class VehicleOperatingState implements VehicleState {
    protected Vehicle _vehicle;

    public VehicleOperatingState(Vehicle vehicle) {
        System.out.println("This vehicle is currently in operation.");
        _vehicle = vehicle;
    }

    public boolean isAvailable() {
        System.out.println("This vehicle is NOT available for service.");
        return false;
    }

    public boolean isScheduled() {
        System.out.println("Vehicle is being scheduled for service.");
        return false;
    }

    public boolean isOperating() {
        System.out.println("Vehicle is currently in operation operating.");
        return true;
    }
}
