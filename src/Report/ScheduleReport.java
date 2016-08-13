package Report;

import Schedule.Schedule;

import java.awt.*;
import java.time.LocalDateTime;

public class ScheduleReport extends Report {
    private Schedule schedule;

    public ScheduleReport(Schedule s ) {
        schedule = s;
    }

    public Schedule getSchedule() {
        return schedule ;
    }

    public void printReport() {
        LocalDateTime startTime = schedule.get_startTime();
        LocalDateTime finishTime = schedule.get_finishTime();
        Point startPoint = schedule.get_startPoint();
        Point endPoint = schedule.get_endPoint();
        float distance = schedule.get_distance();
        float price = schedule.get_price();
        String state = schedule.get_scheduleState().toString();

        System.out.println("---------------------------------------------------");
        System.out.println("Trip Start time:  " + startTime.toString());
        System.out.println("Trip End time:    " + finishTime.toString());
        System.out.println("Trip Start Point: " + startPoint.x + "," + startPoint.y);
        System.out.println("Trip End Point:   " + endPoint.x + "," + endPoint.y);
        System.out.println("Trip Distance:    " + distance);
        System.out.format("Trip Cost:        $%.2f\n",price);
        System.out.println("Trip Status:      " + state);
        System.out.println("---------------------------------------------------");
    }
}
