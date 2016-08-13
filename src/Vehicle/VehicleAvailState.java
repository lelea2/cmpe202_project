package Vehicle;

/**
 * Created by kdao on 8/13/16.
 */
public class VehicleAvailState implements VehicleState {

    protected Vehicle _vehicle;

    public VehicleAvailState(Vehicle vehicle) {
        System.out.println("This vehicle  is available for service.");
        _vehicle = vehicle;
    }

    public boolean isAvailable() {
        System.out.println("This vehicle is available for service.");
        return true;
    }

    public boolean isScheduled() {
        System.out.println("Vehicle is being scheduled for service.");
        _vehicle.setVehicleState(new VehicleScheduledState(_vehicle));
        return false;
    }

    public boolean isOperating() {
        System.out.println("Vehicle is not currently operating.");
        return false;
    }
}
