package Vehicle;

/**
 * Created by kdao on 7/25/16.
 */
public class VanVehicle extends Vehicle {
    public VanVehicle (String vin, String make, String model, VehicleOwnership ownership) {
        super(vin, make, model, ownership);
        numberOfSeats = 7;
        vehicleType = "Van";
    }
}
