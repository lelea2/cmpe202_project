package Schedule;

/**
 * Created by LeonZhang on 8/11/16.
 */
public class Complete implements RequestState{
    private ScheduleInterface schedule;

    public Complete (ScheduleInterface s){
        schedule = s;
    }

    public String receiveScheduleRequest(){
        return "The Schedule is finalized";
    }
    public String matchScheduleRequest(int n){
        return "The Schedule is finalized";
    }
    public String presentScheduleResult(){
        schedule.setState(new Pending(null));
        return "The schedule is completed";
    }
}
