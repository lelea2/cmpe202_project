package Report;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by kdao on 8/14/16.
 */
public class FeedbacksReport extends ServiceCompositeReport<ScheduleReport> {

    public FeedbacksReport(ArrayList<ScheduleReport> reports) {
        super(reports);
        set_description("Feedbacks Report");
    }

}