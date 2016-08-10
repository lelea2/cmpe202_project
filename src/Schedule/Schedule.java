package Schedule;

import Pricing.PricingContext;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import Request.Request;
import Payment.Payment;

/**
 * Created by kdao on 8/7/16.
 */
abstract public class Schedule {
    /*protected Request _request ;
    protected float _price ;
    protected Payment _payment ;
    protected LocalDateTime _startTime ;
    protected LocalDateTime _finishTime ;
    protected Point _startPoint ;
    protected Point _endPoint ;
    protected long _distance ;
    protected VehicleAndDriver _vehicleAndDriver;
    protected ServiceState _serviceState ;
    protected ServiceQueue _serviceQueue ;
    protected ArrayList<ServiceObserver> _observers ;

    public Service(Request request, Payment pay) {
        _request = request;
        _serviceQueue = ServiceQueue.getInstance();
        _serviceState = new QueueingServiceState(this);
        _observers = new ArrayList<>();
        _payment = pay;
        _price = 0;
        _startPoint = _request.getStartPoint();
        _endPoint = _request.getEndPoint();

        if (!(_request.getUser() instanceof Driver)) {
            addObserver(_request.getUser());
        }
    }

    abstract public void setDistance();

    abstract public long getDistanceInMiles();

    abstract public long getTotalTimeInMinutes();

    abstract public float getBidPricePerMile();

    public Request getRequest() { return _request ; }

    public void addToQueue() {
        _serviceQueue.addService(this);
    }

    public void addObserver(ServiceObserver user) {
        _observers.add(user);
    }

    public void removeObserver(ServiceObserver user) {
        _observers.remove(user);
    }

    public void notifyObservers(Object args) {
        if (_observers == null) { return ; }
        Iterator<ServiceObserver> iter = _observers.iterator();
        while(iter.hasNext()) {
            ServiceObserver observer = iter.next();
            observer.update(this, args);
        }
    }

    public ServiceState getServiceState() {
        return _serviceState;
    }

    public void setServiceState(ServiceState s) {
        _serviceState = s ;
        notifyObservers(s);
    }

    public VehicleAndDriver getVehicleAndDriver() {
        return _vehicleAndDriver;
    }

    public void setVehicleAndDriver(VehicleAndDriver vehicleAndDriver) {
        this._vehicleAndDriver = vehicleAndDriver;
        if (vehicleAndDriver.getDriver() != null){
            addObserver(vehicleAndDriver.getDriver());
            vehicleAndDriver.getDriver().setService(this);
        }
    }

    public void setServicePrice() {
        PricingContext pricingContext = new PricingContext();
        _price = pricingContext.getPrice(this);
    }

    public float getPrice() {
        return _price;
    }

    public Driver getDriver() {
        return (_vehicleAndDriver != null) ? _vehicleAndDriver.getDriver() : null;
    }

    public void setDriver(Driver driver) {
        if (_vehicleAndDriver != null){
            _vehicleAndDriver.setDriver(driver);
            setVehicleAndDriver(_vehicleAndDriver);
        }
    }

    public Vehicle getVehicle() {
        return (_vehicleAndDriver != null) ? _vehicleAndDriver.getVehicle() : null;
    }

    public void makePayment() {
        _payment.setAmount(_price);
        System.out.format("Price for service is $%.2f\n", _price);
        _payment.completeTransaction();
    }

    public void queueService() {
        removeObserver(_vehicleAndDriver.getDriver());
        _vehicleAndDriver.getVehicle().setVehicleState(new AvailableState(_vehicleAndDriver.getVehicle()));
        _vehicleAndDriver = null;
        setServiceState(new QueueingServiceState(this));
    }

    public void scheduleService() {
        _serviceState.scheduleService();
    }

    public void approveService() {
        _serviceState.approveService();
    }

    public void payService() {
        _serviceState.payService();
    }

    public void startService() {
        _serviceState.startService();
    }

    public void completeService() {
        _serviceState.completeService();
    }

    public void cancelService() {
        _serviceState.cancelService();
    }

    // Getter functions for protected attributes
    public String getStartTime() {
        if (_startTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = _startTime.format(formatter);
            return formattedDateTime;
        } else {
            return "Not started";
        }
    }

    public String getFinishTime() {
        if (_finishTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = _finishTime.format(formatter);
            return formattedDateTime;
        } else {
            return "Not finished";
        }
    }

    public Point getStartPoint() {
        return _startPoint;
    }

    abstract public void setStartPoint(Point p);

    public Point getEndPoint() {
        return _endPoint;
    }

    abstract public void setEndPoint(Point p);

    public float getDistance() {
        return _distance;
    }*/
}
