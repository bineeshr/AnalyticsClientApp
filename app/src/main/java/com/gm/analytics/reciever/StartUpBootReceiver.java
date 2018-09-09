package com.gm.analytics.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.gm.analytics.util.AppUtil.setAlarmManager;


public class StartUpBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        setAlarmManager(context);
    }
}