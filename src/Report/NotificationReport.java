package Report;

import Notifications.*;

/**
 * Created by kdao on 8/14/16.
 */
public class NotificationReport extends Report {

    private Notifications notifications;

    public NotificationReport(Notifications notifications) {
        this.notifications = notifications;
        _description = "Notification Report";
    }

    public void printReport() {
        System.out.println("\n" + _description);
        System.out.println("=====================================================================");
        System.out.println("Type        : " + notifications.getNotificationType());
        System.out.println("Content     : " + notifications.getNotificationTitle());
        System.out.println("Rating      : " + notifications.getNotificationContent());
        System.out.println("Created Date: " + notifications.getNotificationCreateDate().toString());
        System.out.println("=====================================================================");
    }

}