package Membership;

/**
 * Created by kdao on 7/24/16.
 */
public class GoldMembershipDecorator extends MembershipDecorator {

    public GoldMembershipDecorator(Customer customer) {
        super(customer);
    }

    public void getBenefits() {
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
        return "Gold";
    }
}
