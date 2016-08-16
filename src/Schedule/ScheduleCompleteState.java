package Schedule;


import Request.ApprovedState;

public class ScheduleCompleteState implements ScheduleState {
    private Schedule _schedule;

    public ScheduleCompleteState(Schedule s){
        System.out.println("Schedule is in complete state");
        _schedule = s;
    }

    public void queuing() {
        System.out.println("Cannot queue complete schedule");
    }

    public void approve() {
        System.out.println("Cannot approve schedule has been approved");
    }

    public void start() {
        System.out.println("Cannot start complete schedule");
    }

    public void complete() {
        System.out.println("Cannot complete the complete schedule");
    }

    public void pay() {
        _schedule.set_price();
        _schedule.payment();
        _schedule.set_scheduleState(new SchedulePayState(_schedule)); ;
    }

    public void cancel() {
        System.out.println("Cannot cancel schedule been completed");
    }

    public String getState() {
        return "Complete";
    }
}
