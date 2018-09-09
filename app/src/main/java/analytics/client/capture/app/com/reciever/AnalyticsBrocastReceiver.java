package analytics.client.capture.app.com.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static analytics.client.capture.app.com.util.AppUtil.scheduleJob;

public class AnalyticsBrocastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        scheduleJob(context);
    }




}