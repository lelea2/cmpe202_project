package Feedback;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class DriverFeedback extends Feedback {
    public DriverFeedback(String content, String name, int rating) {
        super(content, name, rating);
    }

    public void setType(){
        System.out.println("This is a customer's feedback.");
    }
}
