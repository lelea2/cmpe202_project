package Dispatch;

import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Vehicle.*;
import Report.*;
import Membership.*;

/**
 * Created by kdao on 8/13/16.
 */
public class DataTest {
    private static DataTest test = null;
    private static ArrayList<VehicleAndDriver> availVehicles = null;
    private static ArrayList<Vehicle> inoperateVehicles = null;
    private static ArrayList<VehicleAndDriverReport> reportList;

    public DataTest() {
        availVehicles = new ArrayList<VehicleAndDriver>();
        inoperateVehicles = new ArrayList<Vehicle>();
        reportList = new ArrayList<VehicleAndDriverReport>();
    }

    public static synchronized DataTest getTest() {
        if (test == null) {
            test = new DataTest();
        }
        return test;
    }

    public List<VehicleAndDriver> getActiveVehicleList() {
        return availVehicles;
    }

    public List<Vehicle> getInoperateVehicleList() {
        return inoperateVehicles;
    }

    public ArrayList<VehicleAndDriverReport> getReportList() {
        return reportList;
    }

    public VehicleAndDriver getFreeVehicleAndDriver() {
        for (VehicleAndDriver vd : availVehicles) {
            if (vd.getVehicle().getState().toString().equalsIgnoreCase("available")) {
                return vd;
            }
        }
        return null;
    }

    public void loadMockData(int numTest) {
        Random rand = new Random(LocalTime.now().toNanoOfDay());
        System.out.println("Loading drivers/vehicles assets...");
        for (int i = 0; i < numTest; i++) {
            VehicleAndDriver vd = new VehicleAndDriver();
            vd.setDriver(new Driver("driver#" + i, "phone#", "email@", "license#", "insurance#"));
            CompactVehicle c = new CompactVehicle("vin#" + i, "make-x", "model-x", 2016, new PersonalOwnedVehicle("driver#" + i));
            c.setLocation(new Point(rand.nextInt(100), rand.nextInt(100)));
            vd.setVehicle(c);
            DataTest.getTest().addVehicleAndDriver(vd);
        }
        for (int j = 0; j < numTest; j++) {
            VehicleAndDriver vd = new VehicleAndDriver();
            vd.setDriver(new Driver("Company#" + j, "phone#", "email@", "license#", "insurance#"));
            Vehicle v = new CompactVehicle("company#" + j, "make-x", "model-x", 2015, new CompanyOwnedVehicle("company#" + j));
            v.setLocation(new Point(50, 50));// right in the middle
            vd.setVehicle(v);
            DataTest.getTest().addVehicleAndDriver(vd);
        }
    }

    public synchronized void addVehicleAndDriver(VehicleAndDriver vd) {
        availVehicles.add(vd);
    }

    public synchronized void addVehicle(Vehicle v) {
        inoperateVehicles.add(v);
    }

}
