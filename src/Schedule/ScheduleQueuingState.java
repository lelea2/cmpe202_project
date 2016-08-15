package Schedule;

/**
 * Created by kdao on 8/13/16.
 */
public class ScheduleQueuingState implements ScheduleState {
    private Schedule _schedule;

    public ScheduleQueuingState(Schedule s){
        System.out.println("Schedule in queuing state. Adding to schedule queue");
        _schedule = s;
        _schedule.addToQueue();
    }

    public void queuing() {
        _schedule.set_scheduleState(new ScheduleApproveState(_schedule)); //Approve queuing schedule
    }

    public void approve() {
        System.out.println("Cannot approve schedule that in queue");
    }
    public void start() {
        System.out.println("Cannot start schedule that not approved");
    }
    public void complete() {
        System.out.println("Cannot complete schedule that not approved");
    }
    public void pay() {
        System.out.println("Cannot pay schedule that in approved");
    }
    public void cancel() {
        System.out.println("Cancel schedule, remove from queue");
        _schedule.removeFromQueue();
    }

    public String getState() {
        return "Queue";
    }
}