package Schedule;

/**
 * Created by LeonZhang on 8/11/16.
 */
 public interface RequestState {
    public String receiveScheduleRequest();
    public String matchScheduleRequest(int n);
    public String presentScheduleResult();
}
