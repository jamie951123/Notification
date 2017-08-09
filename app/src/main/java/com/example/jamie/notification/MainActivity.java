package com.example.jamie.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

import com.example.jamie.notification.Service.NotificationModel;
import com.example.jamie.notification.Service.NotificationServiceImpl;
import com.example.jamie.notification.Service.NotificatonService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button btn;
    private NotificationManager notificationManger;
    private Notification notification;

    private NotificatonService notificatonService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManger = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        btn = (Button)findViewById(R.id.btn);
        editText = (EditText)findViewById(R.id.edit);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn :

                String text = editText.getText().toString();

                Bitmap largeIcon = BitmapFactory.decodeResource(
                        getResources(), R.drawable.notification_black);

                NotificationModel notificationModel = new NotificationModel();
                notificationModel.setMainActivity(this);
                notificationModel.setClassActivity(new HandleNotification());
                notificationModel.setNotification(notification);
                notificationModel.setNotificationManger(notificationManger);

//                notificationModel.setContentTitle("title");
//                notificationModel.setContentInfo("Info");
//                notificationModel.setContentText("Text");
//                notificationModel.setSamllIcon(R.drawable.notifications_white);
//                notificationModel.setLargeIcon(largeIcon);

                RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification_layout);
                contentView.setImageViewResource(R.id.notification_image, R.drawable.notification_color);
                contentView.setTextViewText(R.id.notification_title, "Custom notification");
                if(text != null )contentView.setTextViewText(R.id.notification_text, text);
                contentView.setTextViewText(R.id.notification_time,ObjectUtils.longToH_M(System.currentTimeMillis()));
                contentView.setTextViewText(R.id.notification_info,"");
                notificationModel.setContentView(contentView);




                notificatonService = new NotificationServiceImpl();
                notificatonService.show(notificationModel);
                break;
        }
    }


}
