package Notifications;
/**
 * Created by kdao on 7/22/16.
 * Modified by ycheng on 8/9/16.
 */

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import Membership.*;
import Schedule.*;

public class Notifications implements ScheduleObserver {

    public Notifications(int notificationType, String notificationContent, String notificationTitle) {
        this._notificationType = notificationType;
        this._notificationContent = notificationContent;
        this._notificationTitle = notificationTitle;
        this._notificationCreateDate = new Date();
        // Notification will expire after 1 day
        Calendar c = Calendar.getInstance();
        c.setTime(this._notificationCreateDate);
        c.add(Calendar.DATE, 1);
        this._notificationExpDate = c.getTime();
        this._notificationUpdateDate = null;
        this._id = count.incrementAndGet();
    }

    public void addObserver(Member observer) {
        if (this.observerList == null){
            this.observerList = new LinkedList<Member>();
        }
        this.observerList.add(observer);
    }

    public boolean removeObserver(Member observer) {
        return this.observerList != null && this.observerList.remove(observer);
    }

    public void setNotificationType(int type) {
        if (type >= 0 && type < 3) {
            this._notificationType = type;
            this._notificationUpdateDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(this._notificationUpdateDate);
            c.add(Calendar.DATE, 1);
            this._notificationExpDate = c.getTime();
        }
    }

    public void setNotificationContent(String content) {
        this._notificationContent = content;
        this._notificationUpdateDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(this._notificationUpdateDate);
        c.add(Calendar.DATE, 1);
        this._notificationExpDate = c.getTime();
    }

    public void setNotificationTitle(String title) {
        this._notificationTitle = title;

        this._notificationUpdateDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(this._notificationUpdateDate);
        c.add(Calendar.DATE, 1);
        this._notificationExpDate = c.getTime();
    }

    public int getNotificationType(){
        return this._notificationType;
    }

    public String getNotificationTitle(){
        return this._notificationTitle;
    }

    public String getNotificationContent(){
        return this._notificationContent;
    }

    public Date getNotificationCreateDate(){
        return this._notificationCreateDate;
    }

    public Date getNotificationUpdateDate(){
        return this._notificationUpdateDate;
    }

    public boolean isExpired(){
        return !this._notificationExpDate.after(new Date());
    }

    public void sendNotification() {
        for (Member observer: this.observerList) {
            observer.update(this);
        }
    }

    //////////////////////////
    // Private Members
    //////////////////////////

    private int _notificationType;
    private String _notificationContent;
    private String _notificationTitle;
    private int _id;
    private Date _notificationExpDate;
    private Date _notificationCreateDate;
    private Date _notificationUpdateDate;
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<Member> observerList = new LinkedList<Membership.Member>();

    public void update (Schedule s, Object args) {
        //Implement for schedule observer here
    }
}