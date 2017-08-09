package com.example.jamie.notification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jamie on 9/8/2017.
 */

public class ObjectUtils {

    public static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public static String longToH_M(Long millis){
        String time_str = null;
        if(millis != null ){
            Date date = new Date(millis);
            time_str = format.format(date);
        }
        return time_str;
    }
}
