package com.app.gm.analytics.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.app.gm.analytics.util.AppUtil;


public class StateChangeRecevier extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"STATE_CHANGED",Toast.LENGTH_SHORT).show();
        AppUtil.scheduleJob(context);
    }
}
