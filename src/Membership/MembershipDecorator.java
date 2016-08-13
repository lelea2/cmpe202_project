package Membership;

/**
 * Created by kdao on 7/24/16.
 */
public abstract class MembershipDecorator extends Customer {
    protected Customer _customer;

    public MembershipDecorator(Customer _customer) {
        this._customer = _customer;
    }

    /**
     * Get customer name
     * @return
     */
    public String get_name() {
        return _customer.get_name();
    }

    /**
     * Get phone name
     * @return
     */
    public String get_phoneNumber() {
        return _customer.get_phoneNumber();
    }

    /**
     * Get email
     * @return
     */
    public String get_email() {
        return _customer.get_email();
    }

    /*******************************************************************/
    //Handle member rides
    public int getRides() {
        return _customer.get_rides();
    }
    public void addRide() {
        _customer.addRide();
    }
    /*******************************************************************/


    /*******************************************************************/
    //Handle member mileages
    public long getMileages() {
        return _customer.get_mileages();
    }
    public void addMileages(long miles) {
        _customer.addMileages(miles);
    }
    /*******************************************************************/


    public void getBenefits() {
        _customer.getBenefits();
    }
}
