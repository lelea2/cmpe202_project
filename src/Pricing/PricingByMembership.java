package Pricing;

import Membership.Membership;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class PricingByMembership{

    private final static String GOLD = "Gold";
    private final static String SILVER = "Silver";

    public static double getMemberPrice(Membership membership) {
        if(membership.getLoyaltyStatus() == GOLD){
            return 0.6;
        }else if(membership.getLoyaltyStatus() == SILVER){
            return 0.8;
        }
        //for normal user, no discount.
        return 1;
    }
}
