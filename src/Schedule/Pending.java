package Schedule;

/**
 * Created by LeonZhang on 8/11/16.
 */
public class Pending implements RequestState{
    private ScheduleInterface schedule;

    public Pending(ScheduleInterface s){
        schedule = s;
    }
    public String receiveScheduleRequest(){
        schedule.setState(new Inprogress(schedule));
        return "Receive a new schedule request";
    }
    public  String matchScheduleRequest(int n){
        return "Not receive a new schedule request";
    }
    public  String presentScheduleResult(){
        return "Not receive a new schedule request";
    }
}
