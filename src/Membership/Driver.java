package Membership;

import Schedule.Schedule;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by kdao on 7/22/16.
 */
public class Driver extends Member {
    private String _license;
    private String _insurance;
    //Schedule of driver
    private ArrayList<Schedule> scheduleArrayList;
    private Schedule _schedule;

    //Constructor
    public Driver(String name, String phoneNumber, String email, String license, String insurance) {
        super();
        this._name = name;
        this._phoneNumber = phoneNumber;
        this._email = email;
        this._id = UUID.randomUUID().toString();
        this._license = license;
        this._insurance = insurance;
    }

    public String get_license() {
        return this._license;
    }

    public String get_insurance() {
        return this._insurance;
    }

    /*******************************************************************************/
    //Manage schedule for driver
    public void setSchedule(Schedule schedule) {
        this._schedule = schedule;
    }
    public void addSchedule(Schedule schedule) {
        this.scheduleArrayList.add(schedule);
    }
    public void removeSchedule(Schedule schedule) {
        if (scheduleArrayList.size() > 0) { //If there are availbale schedule
            scheduleArrayList.remove(schedule);
        }
        this._schedule = null;
    }
    //End manage schedule for driver
    /******************************************************************************/

    /*****************************************************************************/
    //Start driver handling his/her own schedule
    public void startSchedule() {
        if (_schedule != null ) {
            _schedule.startSchedule();
        }
    }
    public void cancelSchedule() {
        if (_schedule != null ) { //canceling service
            _schedule.cancelSchedule();
        }
    }
    public void compeleteSchedule() {
        if (_schedule != null ) {
            _schedule.completeSchedule();
        }
    }
    //end driver handling schedule
    /****************************************************************************/

    @Override
    public void update(Object args) {
        System.out.println("Updating driver");
    }
}
