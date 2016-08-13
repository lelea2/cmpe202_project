package Vehicle;

/**
 * Created by kdao on 7/25/16.
 */
public class VanVehicle extends Vehicle {
    public VanVehicle (String vin, String make, String model, int year, VehicleOwnership ownership) {
        super(vin, make, model, year, ownership);
        seats = 7;
        vehicleSize = "L";
    }
}
