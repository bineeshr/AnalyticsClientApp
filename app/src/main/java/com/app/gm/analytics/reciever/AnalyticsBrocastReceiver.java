package com.app.gm.analytics.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.app.gm.analytics.util.AppUtil.scheduleJob;


public class AnalyticsBrocastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        scheduleJob(context);

    }




}