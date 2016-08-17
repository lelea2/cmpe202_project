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

    public void free() {
        System.out.println("This vehicle is not available for service.");
    }

    public void schedule() {
        System.out.println("Vehicle is being scheduled for service.");
    }

    public void operate() {
        System.out.println("Vehicle starts operating.");
        _vehicle.setVehicleState(new VehicleOperatingState(_vehicle));
    }

    public void finish() {
        System.out.println("Vehicle is set up to finish. Schedule state aborted");
        _vehicle.setVehicleState(new VehicleFreeState(_vehicle));
    }

    @Override
    public String toString() {
        return "scheduled";
    }
}
