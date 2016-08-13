package Dispatch;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import Vehicle.VehicleAndDriver;
import Request.*;

/**
 * Created by kdao on 8/13/16.
 */
public class DispatchContext { //TODO: this could be strategy pattern, for simplicity of this project, just implement default one
    public DispatchContext() {
        System.out.println("DispatchContext start...");
    }

    public VehicleAndDriver dispatch(Request rq) {
        List<VehicleAndDriver> cars = DataTest.getInstance().getActiveVehicleList();
        for (VehicleAndDriver car : cars) {
            if (car.getVehicle().getState().toString().equalsIgnoreCase("available")) {
                System.out.println("Car/Driver:" + car.getVehicle().getVin() + "/" + car.getDriver().get_name());
                car.getVehicle().getState().isScheduled();
                return car;
            }
        }
        return null;
    }

}
