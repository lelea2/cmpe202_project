package Schedule;


import Request.Request;

/**
 * Created by LeonZhang on 8/11/16.
 */
public class Schedule{
    private RequestState state;

    public Schedule(){
        state = new Pending(null);
    }

    public void receiveScheduleRequest(){
        System.out.println(state.receiveScheduleRequest());
    }

    public void matchScheduleRequest(int n){
        System.out.println(state.matchScheduleRequest(n));
    }

    public void presentScheduleResult(){
        System.out.println(state.presentScheduleResult());
    }

    public RequestState getState(RequestState s){
        return state;
    }
    public void setState (RequestState s){
        state = s;
    }

}
