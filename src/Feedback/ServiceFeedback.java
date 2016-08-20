package Feedback;

/**
 * Created by YuexingYin on 8/9/16.
 */
public class ServiceFeedback extends Feedback {

    public ServiceFeedback(String content, String name, int rating) {
        super(content, name, rating);
    }

    public void setType(){
        System.out.println("***** This is a service feedback.");
    }

    public String getType() {
        return "Service";
    }

}
