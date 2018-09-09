package com.gm.analytics.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.gm.analytics.reciever.StartUpBootReceiver;
import com.gm.analytics.service.CaptureService;


public class AppUtil {

  public static   void setAlarmManager(Context context) {
        if(RetrieveAnalyticsConfguration.mConfigResponse.analyticsEnabled) {
            Intent alarm = new Intent(context, StartUpBootReceiver.class);
            boolean alarmRunning = (PendingIntent.getBroadcast(context, 0, alarm, PendingIntent.FLAG_NO_CREATE) != null);
            if (alarmRunning == false) {
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarm, 0);
                AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(), 30000, pendingIntent);
            }
            scheduleJob(context);
        }
    }
    public static void scheduleJob(Context context) {
        if(RetrieveAnalyticsConfguration.mConfigResponse.analyticsEnabled) {
            Intent i = new Intent(context, CaptureService.class);
            context.startService(i);
        }
    }


}
