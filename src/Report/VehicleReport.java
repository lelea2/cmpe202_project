package Report;

import Vehicle.Vehicle;

/**
 * Created by LeonZhang on 8/10/16.
 */
public class VehicleReport extends Report {
    private Vehicle vehicle;

    public VehicleReport(Vehicle v){
        vehicle = v;
        set_description("Vehicle Report");
    }

    private String getLocationString(){
        return "" + vehicle.getLocation().x + ", " + vehicle.getLocation().y;
    }

    @Override
    public void printReport() {
        System.out.println("\n" + _description);
        System.out.println("=====================================================================");
        System.out.println("Id      : " + vehicle.getId());
        System.out.println("Vin#    : " + vehicle.getVin());
        System.out.println("Make    : " + vehicle.getMake());
        System.out.println("Model   : " + vehicle.getModel());
        System.out.println("Year    : " + vehicle.getYear());
        System.out.println("Size    : " + vehicle.getVehicleSize());
        System.out.println("Seats#  : " + vehicle.getSeats());
        System.out.println("Owner   : " + vehicle.getOwnership().getOwnerName());
        System.out.println("Location: " + vehicle.getLocation().x + ", " + vehicle.getLocation().y);
        System.out.println("=====================================================================\n");
    }

}
