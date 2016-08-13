package Request;

import Base.DateFormat;
import Rules.RequestRules;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import Membership.Member;
import Schedule.Schedule;

/**
 * Created by kdao on 8/7/16.
 */
public class Request {
    protected Member user;
    protected Date time;
    protected String requestId;
    protected RequestState state;
    protected RequestRules requestRules;
    protected Point startLocation;
    protected Point endLocation;
    protected Schedule schedule;

    /**
     * Get member of a request
     * @return
     */
    public Member getUser(){
        return this.user;
    }

    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getReqTime() {
        if (time != null) {
            return new DateFormat().getCurrentDate();
        } else {
            return "Not started";
        }
    }

    /**
     * Set request state
     * @param state
     */
    public void setState(RequestState state){
        this.state = state;
    }

    /**
     * Get request state
     * @return
     */
    public RequestState getState() {
        return this.state;
    }

    /**
     * Get request Id
     * @return
     */
    public String getRequestId(){
        return this.requestId;
    }

    /**
     * Get request schedule
     * @return
     */
    public Schedule schedule() { return this.schedule; }

    /**
     * Set request schedule
     * @param schedule
     */
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }

    /**
     * Get request starting point
     * @return
     */
    public Point getStartPoint(){
        return this.startLocation;
    }

    /**
     * Get request ending point
     * @return
     */
    public Point getEndPoint(){
        return this.endLocation;
    }

}
