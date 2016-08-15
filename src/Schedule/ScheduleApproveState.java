package Schedule;

import java.time.LocalDateTime;

/**
 * Created by kdao on 8/13/16.
 */
public class ScheduleApproveState implements ScheduleState {
    private Schedule _schedule;

    public ScheduleApproveState(Schedule s){
        System.out.println("Schedule in approved state.");
        _schedule = s;
    }

    public void queuing() {
        System.out.println("Schedule already in queue");
    }
    public void approve() {
        System.out.println("Schedule already approved");
    }
    public void start() {
        System.out.println("Starting Schedule, setting start point, end point, and start time");
        _schedule._startPoint = _schedule.get_request().getStartPoint();
        _schedule._endPoint = _schedule.get_request().getEndPoint();
        _schedule._startTime = LocalDateTime.now();
        _schedule.set_scheduleState(new ScheduleStartState(_schedule)); ;
    }
    public void complete() {
        System.out.println("Cannot complete schedule that not in progress");
    }
    public void pay() {
        System.out.println("Cannot pay for schedule that not in progress");
    }

    public void cancel() {
        System.out.println("Cancel current schedule. Stop all process!!");
    }

    public String getState() {
        return "Approve";
    }
}