package Report;

import Feedback.*;

/**
 * Created by kdao on 8/14/16.
 */
public class FeedbackReport extends Report {

    private Feedback feedback;

    public FeedbackReport(Feedback f) {
        this.feedback = f;
        _description = "Feedback Report";
    }

    public void printReport() {
        System.out.println("\n" + _description);
        System.out.println("=====================================================================");
        System.out.println("Title  : " + feedback.getName());
        System.out.println("Content: " + feedback.getContent());
        System.out.println("Rating : " + feedback.getRating());
        System.out.println("=====================================================================");
    }

}
