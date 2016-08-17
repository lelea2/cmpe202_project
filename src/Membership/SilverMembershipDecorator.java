package Membership;

/**
 * Created by kdao on 7/24/16.
 */
public class SilverMembershipDecorator extends MembershipDecorator {

    public SilverMembershipDecorator(Customer customer) {
        super(customer);
        _loyaltyStatus = "Silver";
    }

    public String getBenefits() {
        return "*** Silver Member ***: Get $10 giftcard with every $200 spent";
    }
}
