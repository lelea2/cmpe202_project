package Vehicle;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import GPS.GPS;

/**
 * Created by kdao on 7/25/16.
 */
public class Vehicle {
    public VehicleOwnership vehicleOwnership;
    protected String vehicleType;
    protected int numberOfSeats;
    private String vehicleId;
    private String vinNumber;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleYear;
    private VehicleState __vehicleState;
    private GPS vehicleGPS;
    private ArrayList<Service> scheduledServices;

    public Vehicle(String vin, String make, String model, VehicleOwnership ownership) {
        vehicleGPS 			= new GPS();
        __vehicleState = new AvailableState(this);
        vinNumber 			= vin;
        vehicleMake 			= make;
        vehicleModel			= model;
        vehicleYear				= "2015";
        vehicleOwnership	= ownership;
        vehicleId 		= UUID.randomUUID().toString().replaceAll("-", "");
        scheduledServices = new ArrayList<Service>();
    }

    public void available() {
        __vehicleState.available();
    }

    public void scheduledForService() {
        __vehicleState.scheduledForService();
    }

    public void providingService() {
        __vehicleState.providingService();
    }

    public void inactive() {
        __vehicleState.inactive();
    }

    public void retired() {
        __vehicleState.retired();
    }

    // Set vehicle state
    public void setVehicleState(VehicleState s) {
        __vehicleState = s;
    }

    // Get vehicle state
    public VehicleState getState() {
        return __vehicleState;
    }

    // Get vehicle current location
    public Point getLocation () {
        return vehicleGPS.getLocation();
    }

    // Set vehicle location
    public void setLocation(Point point) {
        vehicleGPS.setLocation(point);
    }

    // Get methods for private attributes
    public String getVehicleId() {
        return vehicleId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String type) {
        vehicleType = type;
    }

    public VehicleOwnership getVehicleOwnership() {
        return vehicleOwnership;
    }

    public void addScheduledService(Service s){
        scheduledServices.add(s);
    }
    public java.util.List<Service> getScheduledService(){
        return scheduledServices;
    }

    public boolean isFree(LocalDateTime t1){
        for(Service s : scheduledServices){
            LocalDateTime t2 = s.getRequest().getTime();

            long hours = Duration.between(t1, t2).getSeconds() / 3600;

            if (hours <= 1){
                return false;
            }
        }
        return true;
    }
}
