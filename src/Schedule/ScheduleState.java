package Schedule;

public interface ScheduleState {

    public void queuing();
    public void approve();
    public void start();
    public void complete();
    public void pay();
    public void cancel();

    public String getState();

}
