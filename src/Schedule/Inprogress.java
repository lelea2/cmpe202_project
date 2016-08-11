package Schedule;

/**
 * Created by LeonZhang on 8/11/16.
 */
public class Inprogress implements RequestState{
    private ScheduleInterface schedule;

    public Inprogress(ScheduleInterface s){
        schedule = s;
    }
    public String receiveScheduleRequest(){
        return "Already received an scheduleRequest";
    }
    public String matchScheduleRequest(int n){
        if(n == ScheduleInterface.abort){
            return "The schedule is abort";
            schedule.setState(new Pending());
        }
        else{
            return "The schedule in processing";
            schedule.setState(new Complete(schedule));
        }
    }
    public String presentScheduleResult(){
        return "Not process yet";
    }
}
