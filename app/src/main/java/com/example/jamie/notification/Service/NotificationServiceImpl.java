package com.example.jamie.notification.Service;


import android.app.Notification;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;

import com.example.jamie.notification.R;

/**
 * Created by jamie on 9/8/2017.
 */

public class NotificationServiceImpl implements NotificatonService {

    @Override
    public void show(NotificationModel notificationModel) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(notificationModel.getMainActivity());
        builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);
        builder.setWhen(System.currentTimeMillis());
        builder.setContent(notificationModel.getContentView());

        // 準備設定通知效果用的變數
        int defaults = 0;
// 設定通知效果
        builder.setDefaults(defaults);

        long[] vibrate_effect =
                {1000, 500};
// 設定震動效果
        builder.setVibrate(vibrate_effect);
        // 建立通知物件
        Notification notification = builder.build();
// 使用CUSTOM_EFFECT_ID為編號發出通知
        notificationModel.getNotificationManger().notify(notificationModel.getNotification_id(), notification);
    }
}
