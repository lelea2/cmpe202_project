package Membership;

/**
 * Created by kdao on 7/25/16.
 */
public class BasicMembership extends Customer {
    private int _rides;
    private long _mileages;

    public BasicMembership(String name, String phoneNumber, String email) {
        this._name = name;
        this._phoneNumber = phoneNumber;
        this._email = email;
        this._rides = 0;
        this._mileages = 0;
    }

    /*******************************************************************/
    //Handle members ride
    public void addRide() {
        this._rides += 1;
    }

    public int getRides() {
        return this._rides;
    }
    /*******************************************************************/


    /*******************************************************************/
    //Handle member mileages
    public void addMileages(long miles) {
        this._mileages += miles;
    }

    public long getMileages() {
        return this._mileages;
    }
    /*******************************************************************/


    public void getBenefits() {
        System.out.println("Basic customer -- No extra perk!");
    }

}
