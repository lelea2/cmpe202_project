package Membership;

/**
 * Created by kdao on 7/22/16.
 */
public abstract class Customer extends Member {

    protected String _loyaltyStatus;

    //Constructor
    public Customer() {
        super();
    }

    public String getLoyaltyStatus() {
        return _loyaltyStatus;
    }
}
