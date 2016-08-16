package Membership;

/**
 * Created by kdao on 7/24/16.
 */
public class GoldMembershipDecorator extends MembershipDecorator {

    public GoldMembershipDecorator(Customer customer) {
        super(customer);
        _loyaltyStatus = "Gold";
    }

    public String getBenefits() {
        return "*** Gold Member ***: Get $20 giftcard with every $200 spent";
    }
}
