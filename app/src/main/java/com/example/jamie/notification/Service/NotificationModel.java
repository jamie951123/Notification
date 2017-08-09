package com.example.jamie.notification.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

/**
 * Created by jamie on 9/8/2017.
 */

public class NotificationModel {


    private RemoteViews contentView;
    private static final int notification_id = 0;
    private Notification notification;
    private NotificationManager notificationManger;


    //
    private AppCompatActivity mainActivity;
    private AppCompatActivity classActivity;
    //
//    private String contentTitle;
//    private String contentText;
//    private String contentInfo;
//    private int samllIcon;
//    private Bitmap largeIcon;

    public RemoteViews getContentView() {
        return contentView;
    }

    public void setContentView(RemoteViews contentView) {
        this.contentView = contentView;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public NotificationManager getNotificationManger() {
        return notificationManger;
    }

    public void setNotificationManger(NotificationManager notificationManger) {
        this.notificationManger = notificationManger;
    }

    public AppCompatActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(AppCompatActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public AppCompatActivity getClassActivity() {
        return classActivity;
    }

    public void setClassActivity(AppCompatActivity classActivity) {
        this.classActivity = classActivity;
    }
}
