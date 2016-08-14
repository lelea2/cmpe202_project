package Report;

import Vehicle.*;

/**
 * Created by kdao on 8/13/16.
 */
public class VehicleAndDriverReport extends Report {
    private VehicleAndDriver data;

    public VehicleAndDriverReport(VehicleAndDriver data) {
        this.data = data;
    }

    @Override
    public void printReport() {
        if (data.getDriver() != null) {
            VehicleReport vehicleReport = new VehicleReport(data.getVehicle());
            vehicleReport.printReport();
        }
        if (data.getDriver() != null) {
            DriverReport driverReport = new DriverReport(data.getDriver());
            driverReport.printReport();
        }
        if (data.getVehicle().getState().toString().equalsIgnoreCase("available")) {
            System.out.println("Availability:      Free");
        }
        else {
            System.out.println("Availability:      Not free\n");
        }
    }
}
