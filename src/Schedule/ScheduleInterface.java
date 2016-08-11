package Schedule;



/**
 * Created by LeonZhang on 8/11/16.
 */
public interface ScheduleInterface {
    public static final int abort = 0;

    public void receiveScheduleRequest();
    public void matchScheduleRequest(int n);
    public void presentScheduleResult();

    public RequestState getState();
    public void setState(RequestState s);

}
