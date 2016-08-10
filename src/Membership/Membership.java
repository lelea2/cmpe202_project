package Membership;

/**
 * Created by kdao on 7/25/16.
 */
public abstract class Membership extends Member {
    protected String _loyaltyStatus;
    private int __rides;
    private long __totalMiles;

    public String getLoyaltyStatus() {
        return _loyaltyStatus;
    }

    public void addRide() {
        this.__rides += 1;
    }

    public int getRides() {
        return this.__rides;
    }

    public void addMiles(long miles) {
        this.__totalMiles += miles;
    }

    public long getTotalMiles() {
        return this.__totalMiles;
    }

    public abstract void checkBenefits();

    public void update(Object args) {}
}
