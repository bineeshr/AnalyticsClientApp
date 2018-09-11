package com.gm.analytics.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.gm.analytics.util.AnalyticsUtil;


public class UserSwitchReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"SwitchUser",Toast.LENGTH_SHORT).show();
        AnalyticsUtil.scheduleJob(context);
    }
}
