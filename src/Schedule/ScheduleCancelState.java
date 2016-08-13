package Schedule;

/**
 * Created by kdao on 8/13/16.
 */
public class ScheduleCancelState implements ScheduleState {
    private Schedule _schedule;

    public ScheduleCancelState(Schedule s){
        System.out.println("Schedule in cancelled state.");
        _schedule = s;
    }

    public void queuing() {
        System.out.println("Cannot queue schedule that is cancelled");
    }
    public void approve() {
        System.out.println("Cannot approve schedule that is cancelled");
    }
    public void start() {
        System.out.println("Cannot start schedule that is cancelled");
    }
    public void complete() {
        System.out.println("Cannot complete schedule that is cancelled");
    }
    public void pay() {
        System.out.println("Cannot pay schedule that is cancelled");
    }
    public void cancel() {
        System.out.println("Cancelling...");
    }
}
