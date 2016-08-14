package TestSuite;

import Report.SchedulesReport;
import Request.*;
import Schedule.*;
import Membership.*;
import Vehicle.*;
import Dispatch.*;
import java.awt.*;

/**
 * Created by kdao on 8/14/16.
 */
//Helper test to generate multiple requests at the same time
public class Multiple_Request_Test {
    public static void main(String[] args) {
        DataTest.getTest().loadObjectsForTesting(12);
        Request olr1 = new Request(new BasicMembership("Khanh", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));
        Request olr2 = new Request(new BasicMembership("Leon", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));
        Request olr3 = new Request(new BasicMembership("Yucheng", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));
        Request olr4 = new Request(new BasicMembership("Yuexing", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));
        Request olr5 = new Request(new BasicMembership("Kareen", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));
        Request olr6 = new Request(new BasicMembership("Kayla", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));
        Request olr7 = new Request(new BasicMembership("John", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));
        Request olr8 = new Request(new BasicMembership("Justin", "123456789", "test@test.com"),
                new Point(5, 10), new Point(70, 87));
        Request olr9 = new Request(new BasicMembership("Sophie", "123456789", "test@test.com"),
                new Point(1, 2), new Point(2, 3));

        ScheduleQueue scheduleQueue = ScheduleQueue.getQueue();
        printSchedules();

        scheduleQueue.processSchedule();
        printSchedules();

        //Start active services
        for (VehicleAndDriver vd : DataTest.getTest().getActiveVehicleList()) {
            vd.getDriver().startSchedule(); ;
        }
        //End active services
        for (VehicleAndDriver vd : DataTest.getTest().getActiveVehicleList()) {
            vd.getDriver().cancelSchedule(); ;
        }
        printSchedules();
    }

    public static void printSchedules() {
        SchedulesReport schedulesReport = new SchedulesReport(ScheduleQueue.getQueue().getScheduleReportsList());
        schedulesReport.printReport();
    }
}