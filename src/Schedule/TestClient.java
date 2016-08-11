package Schedule;

/**
 * Created by LeonZhang on 8/11/16.
 */
public class TestClient {

    public static void main (String[] arg){
        Schedule schedule = new Schedule() ;
        schedule.receiveScheduleRequest();
        schedule.matchScheduleRequest(1);
        schedule.presentScheduleResult();
    }
}
