package Report;

import java.util.*;

/**
 * Created by kdao on 8/13/16.
 */
public class SchedulesReport extends ServiceCompositeReport<ScheduleReport> {

    public SchedulesReport(ArrayList<ScheduleReport> reports) {
        super(reports);
        set_description("Schedules Report");
    }

}