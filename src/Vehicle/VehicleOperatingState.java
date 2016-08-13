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

    public void free() {
        System.out.println("This vehicle is NOT available for service.");
    }

    public void schedule() {
        System.out.println("Vehicle is NOT available for scheduled for service.");
    }

    public void operate() {
        System.out.println("Vehicle is currently in operation operating.");
    }

    public void finish() {
        System.out.println("Vehicle is set up to finish. Schedule state aborted");
        _vehicle.setVehicleState(new VehicleFreeState(_vehicle));
    }
}
