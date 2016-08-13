package Membership;

/**
 * Created by kdao on 7/25/16.
 */
public class BasicMembership extends Customer {
    private int __rides;
    private long __totalMiles;

    public BasicMembership(String name, String phoneNumber) {
        this._name = name;
        this._phoneNumber = phoneNumber;
        this.__rides = 0;
        this.__totalMiles = 0;
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

    public void checkBenefits() {
        System.out.println("No benefits");
    }

}
