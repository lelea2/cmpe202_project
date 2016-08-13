package Vehicle;

/**
 * Created by kdao on 7/25/16.
 */
public class CompactVehicle extends Vehicle{
    public CompactVehicle (String vin, String make, String model, VehicleOwnership ownership) {
        super(vin, make, model, ownership);
        numberOfSeats = 5;
        vehicleType = "Compact";
    }
}
