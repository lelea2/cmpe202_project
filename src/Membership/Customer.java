package Membership;

/**
 * Created by kdao on 7/25/16.
 */
public abstract class Customer extends Member {
    protected String _loyaltyStatus;
    private int _rides;
    private long _mileages;

    public String getLoyaltyStatus() {
        return _loyaltyStatus;
    }

    public void addRide() {
        this._rides += 1;
    }

    public int get_rides() {
        return this._rides;
    }

    public void addMileages(long miles) {
        this._mileages += miles;
    }

    public long get_mileages() {
        return this._mileages;
    }

    public abstract String getBenefits();

    //TODO: member become observer class to update status
    public void update(Object args) {
        System.out.println("Updating membership status");
    }
}
