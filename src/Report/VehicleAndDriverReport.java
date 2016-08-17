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
        if (data.getVehicle() != null) {
            VehicleReport vehicleReport = new VehicleReport(data.getVehicle());
            vehicleReport.printReport();
        }
        if (data.getDriver() != null) {
            DriverReport driverReport = new DriverReport(data.getDriver());
            driverReport.printReport();
        }
        if (data.getVehicle().getState().toString().equalsIgnoreCase("free")) { //vehicle state free
            System.out.println("Vehicle State: Free\n");
        } else {
            System.out.println("Vehicle state: Not free\n");
        }
    }
}
