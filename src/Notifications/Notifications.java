package Notifications;
/**
 * Created by kdao on 7/22/16.
 * Modified by ycheng on 8/9/16.
 */

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import Membership.Member;


public class Notifications {

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

    public void AddObserver(Membership.Member observer){
        if (this.observerList == null){
            this.observerList = new LinkedList<Membership.Member>();
        }
        this.observerList.add(observer);
    }

    public boolean RemoveObserver(Membership.Member observer){
        return this.observerList != null && this.observerList.remove(observer);
    }

    public void SetNotificationType(int type){
        if (type >= 0 && type < 3){
            this._notificationType = type;

            this._notificationUpdateDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(this._notificationUpdateDate);
            c.add(Calendar.DATE, 1);
            this._notificationExpDate = c.getTime();
        }
    }

    public void SetNotificationContent(String content){
        this._notificationContent = content;

        this._notificationUpdateDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(this._notificationUpdateDate);
        c.add(Calendar.DATE, 1);
        this._notificationExpDate = c.getTime();
    }

    public void SetNotificationTitle(String title){
        this._notificationTitle = title;

        this._notificationUpdateDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(this._notificationUpdateDate);
        c.add(Calendar.DATE, 1);
        this._notificationExpDate = c.getTime();
    }

    public int GetNotificationType(){
        return this._notificationType;
    }

    public String GetNotificationTitle(){
        return this._notificationTitle;
    }

    public String GetNotificationContent(){
        return this._notificationContent;
    }

    public Date GetNotificationCreateDate(){
        return this._notificationCreateDate;
    }

    public Date GetNotificationUpdateDate(){
        return this._notificationUpdateDate;
    }

    public boolean IsExpired(){
        return !this._notificationExpDate.after(new Date());
    }

    public void SendNotification(){
        for (Membership.Member observer: this.observerList){
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
    private List<Membership.Member> observerList = new LinkedList<Membership.Member>();
}