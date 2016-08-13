package Vehicle;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

import GPS.GPS;
import Schedule.Schedule;

/**
 * Created by kdao on 7/25/16.
 */
abstract public class Vehicle {
    public VehicleOwnership ownership;
    protected String vehicleSize;
    protected int seats;
    private String id;
    private String vin;
    private String make;
    private String model;
    private int year;
    private VehicleState state;
    private GPS vehicleGPS; //find where vehicle is (tracking vehicle
    private ArrayList<Schedule> schedulesList;
    private int FREE_PERIOD_MIN = 2; //2 HOUR set between schedule free is set

    public Vehicle(String vin, String make, String model, int year, VehicleOwnership ownership) {
        this.vin = vin; //vehicle vin number
        this.make = make; //vehicle make, Eg: Toyota
        this.model = model; //Vehicle model, Eg: model
        this.year = year; //Vehicle year, Eg: year
        this.ownership = ownership; //Vehicle ownership
        vehicleGPS = new GPS();
        state = new VehicleFreeState(this);
        id = UUID.randomUUID().toString();
    }

    /**********************************************************************************/
    //Vehicle state
    public void free() {
        state.free();
    }
    public void schedule() {
        state.schedule();
    }
    public void operate() {
        state.operate();
    }
    public void finish() {
        state.finish();
    }
    //Finish vehicle state
    /*********************************************************************************/

    //Function to add schedule for given vehicle
    public void addSchedule(Schedule schedule){
        schedulesList.add(schedule);
    }
    //Function return schedule list for current vehicle
    public List<Schedule> getSchedulesList(){
        return schedulesList;
    }

    public boolean isVehicleFree(LocalDateTime t1){
        for(Schedule s : schedulesList){
            LocalDateTime t2 = s.get_request().getTime();
            long hours = Duration.between(t1, t2).getSeconds() / 3600;
            if (hours <= FREE_PERIOD_MIN) {
                return false;
            }
        }
        return true;
    }

    /**
     * Set vehicle state
     * @param state
     */
    public void setVehicleState(VehicleState state) {
        this.state = state;
    }

    /**
     * Get vehicle state
     * @return
     */
    public VehicleState getState() {
        return state;
    }

    /**
     * Track vehicle location
     * @return
     */
    public Point getLocation () {
        return vehicleGPS.getLocation();
    }

    /**
     * Set vehicle location
     * @param point
     */
    public void setLocation(Point point) {
        vehicleGPS.setLocation(point);
    }

    /**
     * Get vehicle id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Get vehicle VIN
     * @return
     */
    public String getVin() {
        return vin;
    }

    /**
     * Get vehicle make
     * @return
     */
    public String getMake() {
        return make;
    }

    /**
     * Get vehicle model
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * Get vehicle year
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * Get vehicle seats
     * @return
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Get vehicle size
     * @return
     */
    public String getVehicleSize() {
        return vehicleSize;
    }

    /**
     * Set vehicle size
     * @param size
     */
    public void setVehicleSize(String size) {
        vehicleSize = size;
    }

    /**
     * Get vehicle ownership
     * @return
     */
    public VehicleOwnership getOwnership() {
        return ownership;
    }
}
