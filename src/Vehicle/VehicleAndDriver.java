package Vehicle;

import Membership.Driver;

/**
 * Created by kdao on 8/13/16.
 */
public class VehicleAndDriver {
    private Vehicle vehicle;
    private Driver driver;

    //Constructor
    public VehicleAndDriver(Driver driver, Vehicle vehicle) {
        this.driver = driver;
        this.vehicle = vehicle;
    }

    public VehicleAndDriver() {}

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
