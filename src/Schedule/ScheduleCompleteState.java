package Schedule;


import Request.ApprovedState;

public class ScheduleCompleteState implements ScheduleState {
    private Schedule _schedule;

    public ScheduleCompleteState(Schedule s){
        System.out.println("Schedule in queuing state. Adding to schedule queue");
        _schedule = s;
        s.addToQueue();
    }

    public void queuing() {
        _schedule.set_scheduleState(new ScheduleApproveState(_schedule));
        _schedule.get_request().setState(new ApprovedState(_schedule.get_request()));
    }
    public void approve() {}
    public void start() {}
    public void complete() {}
    public void pay() {}
    public void cancel() {}

    public String getState() {
        return "Complete";
    }
}
