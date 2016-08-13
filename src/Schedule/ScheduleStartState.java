package Schedule;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by kdao on 8/13/16.
 */
public class ScheduleStartState implements ScheduleState {
    private Schedule _schedule;

    public ScheduleStartState(Schedule s){
        System.out.println("Schedule in starting state.");
        _schedule = s;
    }

    public void queuing() {
        System.out.println("Do not queue schedule that has been started");
    }
    public void approve() {
        System.out.println("Cannot approve schedule that has been started");
    }
    public void start() {
        System.out.println("Do start schedule that has been started");
    }

    public void complete() { //Complete state of a start process
        Random r = new Random();
        _schedule.setDistance();
        long d = _schedule.getDistanceInMiles();
        _schedule._finishTime = LocalDateTime.now().plusMinutes(d * r.nextInt(4) + 1);
        _schedule.set_scheduleState(new ScheduleCompleteState(_schedule)); //Complete trip
        _schedule.paySchedule();
    }

    public void pay() {
        System.out.println("Cannot pay for schedule not complete");
    }

    public void cancel() {
        System.out.println("Cancel current schedule. Stop all process!!");
        //TODO: calculate how much time has travelled to charge
    }
}
