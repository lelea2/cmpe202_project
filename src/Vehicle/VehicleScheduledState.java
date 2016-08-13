package Vehicle;

/**
 * Created by kdao on 8/13/16.
 */
public class VehicleScheduledState implements VehicleState {
    protected Vehicle _vehicle;

    public VehicleScheduledState(Vehicle vehicle) {
        System.out.println("This vehicle is scheduled for service.");
        _vehicle = vehicle;
    }

    public boolean isAvailable() {
        System.out.println("This vehicle is not available for service.");
        return false;
    }

    public boolean isScheduled() {
        System.out.println("Vehicle is being scheduled for service.");
        return true;
    }

    public boolean isOperating() {
        System.out.println("Vehicle starts operating.");
        _vehicle.setVehicleState(new VehicleOperatingState(_vehicle));
        return false;
    }
}
