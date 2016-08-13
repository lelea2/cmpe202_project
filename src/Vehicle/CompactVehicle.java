package Vehicle;

/**
 * Created by kdao on 7/25/16.
 */
public class CompactVehicle extends Vehicle {
    public CompactVehicle (String vin, String make, String model, int year, VehicleOwnership ownership) {
        super(vin, make, model, year, ownership);
        seats = 5;
        vehicleSize = "M";
    }
}
