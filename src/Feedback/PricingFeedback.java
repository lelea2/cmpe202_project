package Feedback;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class PricingFeedback extends Feedback {
    public PricingFeedback(String content, String name, int rating) {
        super(content, name, rating);
    }

    public void setType(){
        System.out.println("***** This is a pricing feedback.");
    }

    public String getType() {
        return "Pricing";
    }
}
