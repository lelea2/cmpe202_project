package Report;

import Schedule.Schedule;

import java.awt.*;
import java.time.LocalDateTime;

public class ScheduleReport extends Report {
    private Schedule schedule;

    public ScheduleReport(Schedule s ) {
        schedule = s;
        set_description("Schedule Report");
    }

    public Schedule getSchedule() {
        return schedule ;
    }

    public void printReport() {
        String startTime = schedule.get_startTime();
        String finishTime = schedule.get_finishTime();
        Point startPoint = schedule.get_startPoint();
        Point endPoint = schedule.get_endPoint();
        float distance = schedule.get_distance();
        double price = schedule.get_price();
        String state = schedule.get_scheduleState().getState();

        System.out.println("=====================================================================");
        System.out.println("\n" + _description);
        System.out.println("Start time : " + startTime.toString());
        System.out.println("End time   : " + finishTime.toString());
        System.out.println("Start Point: " + startPoint.x + "," + startPoint.y);
        System.out.println("End Point  : " + endPoint.x + "," + endPoint.y);
        System.out.println("Distance   : " + distance);
        System.out.format("Cost       : $%.2f\n",price);
        System.out.println("Status     : " + state);
        System.out.println("=====================================================================");
    }
}
