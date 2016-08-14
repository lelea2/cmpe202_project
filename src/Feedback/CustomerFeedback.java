package Feedback;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class CustomerFeedback extends Feedback {
    public CustomerFeedback(String content, String name, int rating) {
        super(content, name, rating);
    }

    public void setType(){
        System.out.println("This is a customer's feedback.");
    }
}
