package Membership;

/**
 * Created by kdao on 7/24/16.
 */
public abstract class MembershipDecorator extends Membership {
    protected Membership _decoratedCustomer;

    public MembershipDecorator(Membership decoratedCustomer) {
        _decoratedCustomer = decoratedCustomer;

    }

    public String get_name() {
        return _decoratedCustomer.get_firstName() + " "  + _decoratedCustomer.get_lastName();
    }

    public String get_phoneNumber() {
        return _decoratedCustomer.get_phoneNumber();
    }
    public int getRides() {
        return _decoratedCustomer.getRides();
    }
    public long getTotalMiles() {
        return _decoratedCustomer.getTotalMiles();
    }
    public void addRide() {
        _decoratedCustomer.addRide();
    }
    public void addMiles(long miles) {
        _decoratedCustomer.addMiles(miles);
    }

    public void checkBenefits() {
        _decoratedCustomer.checkBenefits();
    }
}
