package Membership;

/**
 * Created by kdao on 7/24/16.
 */
public abstract class MembershipDecorator extends Membership {
    protected Membership _membership;

    public MembershipDecorator(Membership _membership) {
        _membership = _membership;
    }

    public String get_name() {
        return _membership.get_firstName() + " "  + _membership.get_lastName();
    }

    public String get_phoneNumber() {
        return _membership.get_phoneNumber();
    }
    public int getRides() {
        return _membership.getRides();
    }
    public long getTotalMiles() {
        return _membership.getTotalMiles();
    }
    public void addRide() {
        _membership.addRide();
    }
    public void addMiles(long miles) {
        _membership.addMiles(miles);
    }

    public void checkBenefits() {
        _membership.checkBenefits();
    }
}
