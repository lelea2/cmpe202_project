package Membership;

import java.util.UUID;

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
        this._id = UUID.randomUUID().toString();
        this._rides = 0;
        this._mileages = 0;
        _loyaltyStatus = "Basic";
    }

    /*******************************************************************/
    //Handle members ride
    public void addRide() {
        this._rides += 1;
    }

    public int get_rides() {
        return this._rides;
    }
    /*******************************************************************/


    /*******************************************************************/
    //Handle member mileages
    public void addMileages(long miles) {
        this._mileages += miles;
    }

    public long get_mileages() {
        return this._mileages;
    }
    /*******************************************************************/

    public String getBenefits() {
        return "Basic customer -- No extra perk!";
    }

}
