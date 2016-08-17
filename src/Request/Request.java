package Request;

import Base.DateFormat;
import Rules.RequestRules;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.UUID;

import Membership.Member;
import Schedule.Schedule;

/**
 * Created by kdao on 8/7/16.
 */
public class Request {
    protected Member user;
    protected LocalDateTime time;
    protected String requestId;
    protected RequestState state;
    protected RequestRules requestRules;
    protected Point startLocation;
    protected Point endLocation;
    protected Schedule schedule;

    //Constructor set up for request
    //Note: Eg: could extend this to online/phone request
    public Request(Member member, Point startLocation, Point endLocation ) {
        this.user = member;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.requestId = UUID.randomUUID().toString();
        this.requestRules = new RequestRules(this);
        this.time = LocalDateTime.now(); //Time stamp for request staarting
        this.state = new PendingState(this);
    }

    public void processRequest() {
        System.out.println("Processing new request....");
        this.getState().goToNextState(); //proceeding pending request, validate for scheduling
    }

    /**
     * Get member of a request
     * @return
     */
    public Member getUser(){
        return this.user;
    }

    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
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
    public void setState(RequestState state) {
//        System.out.println("Setting new request state");
//        System.out.println(state);
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
    public Schedule getSchedule() { return this.schedule; }

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
