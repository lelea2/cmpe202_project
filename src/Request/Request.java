package Request;

import Rules.RequestRules;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Membership.Member;
import Schedule.Schedule;

/**
 * Created by kdao on 8/7/16.
 */
public class Request {
    protected Member _user;
    protected LocalDateTime _time;
    protected String _requestId;
    protected RequestState _requestState;
    protected RequestRules _requestRules;
    protected Point _startLocation;
    protected Point _endLocation;
    protected Schedule _schedule;

    public void setState(RequestState state){
        this._requestState = state;
    }

    public RequestState getRequestState() {
        return this._requestState;
    }

    public String getRequestId(){
        return this._requestId;
    }

    public Member getUser(){
        return this._user;
    }

    public Schedule getService() { return this._schedule; }

    /*public void cancelService() {
        if (_schedule != null) {
            _schedule.cancelService();
        }
    }*/

    public void setService(Schedule schedule) { this._schedule = schedule; }

    public Point getStartPoint(){
        return this._startLocation;
    }

    public Point getEndPoint(){
        return this._endLocation;
    }

    public LocalDateTime getTime() {
        return _time;
    }

    public String getRequetTime() {
        if (_time != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = _time.format(formatter);
            return formattedDateTime;
        } else {
            return "Not started";
        }
    }

    public void setTime(LocalDateTime time) {
        this._time = time;
    }

}
