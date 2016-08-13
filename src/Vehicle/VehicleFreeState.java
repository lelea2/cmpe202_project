package Vehicle;

/**
 * Created by kdao on 8/13/16.
 */
public class VehicleFreeState implements VehicleState {

    protected Vehicle _vehicle;

    public VehicleFreeState(Vehicle vehicle) {
        System.out.println("This vehicle  is available for service.");
        _vehicle = vehicle;
    }

    public void free() {
        System.out.println("This vehicle is available for service.");
    }

    public void schedule() {
        System.out.println("Vehicle is being scheduled for service.");
        _vehicle.setVehicleState(new VehicleScheduledState(_vehicle));
    }

    public void operate() {
        System.out.println("Cannot operate vehicle not in schedule.");
    }

    public void finish() {
        System.out.println("Cannot finish with free vehicle");
    }
}
