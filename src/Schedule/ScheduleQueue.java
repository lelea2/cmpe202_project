package Schedule;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import Report.*;
import Dispatch.*;
import Vehicle.*;
import Membership.*;

/**
 * Created by kdao on 8/13/16.
 */
public class ScheduleQueue {
    private static ScheduleQueue scheduleQueue = null;
    protected ArrayDeque<Schedule> _scheduleQueue;
    protected ArrayList<ScheduleReport> scheduleReportsList;
    protected DispatchContext _dispatcher;

    private int RESERVE_DURATION_MIN = 3600 * 2; //If request hour is > 2 hour ahead, make reservation

    private ScheduleQueue() {
        _scheduleQueue = new ArrayDeque<>();
        _dispatcher = new DispatchContext();
        scheduleReportsList = new ArrayList<ScheduleReport>();
    }

    public static synchronized ScheduleQueue getQueue() {
        if (scheduleQueue == null) {
            scheduleQueue = new ScheduleQueue();
        }
        return scheduleQueue;
    }

    /**
     * Helper function to add schedule in queue
     * @param schedule
     */
    public void addSchedule(Schedule schedule) {
        System.out.println("Add schedule to schedule queue..........");
        LocalDateTime now = LocalDateTime.now(); //java8 date time
        LocalDateTime reqTime = null;
        try {
            reqTime = schedule.get_request().getTime();
        } catch(Exception ex) {
            System.out.println(schedule.get_request());
            System.out.println(ex);
        }
        long reservation = Duration.between(now, reqTime).getSeconds();

        if(schedule.get_request().getUser() instanceof Driver) {
            List<VehicleAndDriver> vdList = DataTest.getTest().getActiveVehicleList();
            for(VehicleAndDriver vd : vdList) {
                if (vd.getDriver().get_name().equals(schedule.get_request().getUser().get_name())){
                    _scheduleQueue.add(schedule);
                    return;
                }
            }
        }
        if (reservation > RESERVE_DURATION_MIN) {
            VehicleAndDriver vehicleAndDriver = _dispatcher.dispatch(schedule.get_request());
            vehicleAndDriver.getVehicle().addSchedule(schedule);
            System.out.println(">>>> Reserved vehicle for the schedule: vin:" + vehicleAndDriver.getVehicle().getVin() + "<<<<<");
        } else {
            System.out.println("Add new schedule to ScheduleQueue");
            _scheduleQueue.add(schedule);
            boolean new_schedule = true ;
            for(ScheduleReport s : scheduleReportsList) {
                if (s.getSchedule() == schedule) { //If schedule already exists then don't add to list of schedule
                    new_schedule = false;
                }
            }
            if (new_schedule) {
                scheduleReportsList.add(new ScheduleReport(schedule));
            }
        }
    }

    /**
     * Helper function to remove schedule
     * @param s
     */
    public void removeSchedule(Schedule s) {
        _scheduleQueue.remove(s);
    }

    //Process schedule queue
    public void processSchedule() {
        VehicleAndDriver vehicleAndDriver;
        Schedule schedule;
        while (_scheduleQueue.size() != 0) {
            System.out.println("Process schedule queue...............");
            schedule = _scheduleQueue.getFirst(); //get first in queue
            vehicleAndDriver = _dispatcher.dispatch(schedule.get_request()); //call dispatch schedule
            System.out.println(vehicleAndDriver);
            if (vehicleAndDriver != null) {
                System.out.println("Name of Driver is " + vehicleAndDriver.getDriver().get_name());
                vehicleAndDriver.getVehicle().setVehicleState(new VehicleScheduledState(vehicleAndDriver.getVehicle()));
                schedule.set_vehicleAndDriver(vehicleAndDriver);
                schedule.queuingSchedule(); //put schedule in queing state
                removeSchedule(schedule);
            } else {
                break; //do not do anything if nothing lefted in scheudule
            }
        }
    }

    /**
     * Helper function to get next schedule in queue
     * @return
     */
    public Schedule getNextSchedule() {
        return _scheduleQueue.getFirst();
    }

    /**
     * Helper function to get schedule report list
     * @return
     */
    public ArrayList<ScheduleReport> getScheduleReportsList() {
        return scheduleReportsList;
    }

}
