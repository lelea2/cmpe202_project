package Membership;

/**
 * Created by kdao on 7/24/16.
 */
public class SilverMembershipDecorator extends MembershipDecorator {

    public SilverMembershipDecorator(Customer membership) {
        super(membership);
    }

    public void checkBenefits() {
        showCondiments();
        showAmenities();
    }

    public void showCondiments() {
        System.out.println("Condiments: Peanuts and Soda");
    }

    public void showAmenities() {
        System.out.println("Amenities: Pillow");
    }

    public String toString() {
        return "Silver";
    }
}
