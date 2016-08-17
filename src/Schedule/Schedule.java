package Schedule;

import Pricing.PricingContext;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDateTime;

import Request.Request;
import Payment.Payment;
import Vehicle.VehicleAndDriver;
import Membership.*;


/**
 * Created by kdao on 8/7/16.
 */
abstract public class Schedule {
    protected Request _request ;
    protected Payment _payment ;
    protected LocalDateTime _startTime ;
    protected LocalDateTime _finishTime ;
    protected Point _startPoint ;
    protected Point _endPoint ;
    protected long _distance ;
    protected VehicleAndDriver _vehicleAndDriver;
    protected ScheduleState _scheduleState ;
    protected ScheduleQueue _scheduleQueue ;
    protected ArrayList<ScheduleObserver> _observers;
    protected double _price ;

    public Schedule(Request request, Payment payment) {
        _request = request;
        _scheduleQueue = ScheduleQueue.getQueue();
        _scheduleState = new ScheduleQueuingState(this); //Initial setting for schedule state
        _observers = new ArrayList<>();
        _payment = payment;
        _price = 0;
        _startPoint = _request.getStartPoint();
        _endPoint = _request.getEndPoint();
    }

    /*****************************************************************************/
    //Helper function to add current schedule to queue
    public void addToQueue() {
        _scheduleQueue.addSchedule(this);
    }

    public void removeFromQueue() {
        _scheduleQueue.removeSchedule(this);
    }

    public void addObserver(ScheduleObserver schedule) {
        _observers.add(schedule);
    }

    public void removeObserver(ScheduleObserver schedule) {
        _observers.remove(schedule);
    }

    /*********************************************************/
    //Getter
    public ScheduleState get_scheduleState() {
        return _scheduleState;
    }

    public void set_scheduleState(ScheduleState s) {
        _scheduleState = s ;
    }

    public Request get_request() {
        return _request;
    }

    public Payment get_payment() {
        return _payment;
    }

    //Helper function to get start time
    public String get_startTime() {
        if (_startTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = _startTime.format(formatter);
            return formattedDateTime;
        } else {
            return "Not started";
        }
    }

    //Helper function to get finish time
    public String get_finishTime() {
        if (_finishTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = _finishTime.format(formatter);
            return formattedDateTime;
        } else {
            return "Not finished";
        }
    }

    public Point get_startPoint() {
        return _startPoint;
    }

    public Point get_endPoint() {
        return _endPoint;
    }

    public long get_distance() {
        return _distance;
    }

    public VehicleAndDriver get_vehicleAndDriver() {
        return _vehicleAndDriver;
    }

    public void set_vehicleAndDriver(VehicleAndDriver _vehicleAndDriver) {
        this._vehicleAndDriver = _vehicleAndDriver;
    }

    /******************************/
    //Set price
    public void set_price() {
        PricingContext pricingContext = new PricingContext();
        _price = pricingContext.getPrice(this);
    }

    public double get_price() {
        return _price;
    }

    public void payment() {
        _payment.set_paymentAmount(_price);
        System.out.format("Final price for service is $%.2f\n", _price);
        _payment.completeTransaction();
    }
    /*****************************/

    //End Getter
    /**************************************************************************************/

    /*************************************************************************************/
    //The following is to execute state of a schedule
    public void queuingSchedule() {
        _scheduleState.queuing();
    }
    public void approveSchedule() {
        _scheduleState.approve();
    }

    public void startSchedule() {
        _scheduleState.start();
    }

    public void completeSchedule() {
        _scheduleState.complete();
    }

    public void paySchedule() {
        _scheduleState.pay();
    }

    public void cancelSchedule() {
        _scheduleState.cancel();
    }

    //abstract class
    abstract public void set_startPoint(Point p);
    abstract public void set_endPoint(Point p);
    abstract public void setDistance();
    abstract public long getDistance();
    abstract public long getTotalTime();
}
