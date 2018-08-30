package analytics.client.capture.app.com.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import analytics.client.capture.app.com.workmanger.CaptureAnalyticsWork;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class AnalyticsBrocastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        setWorkerManager();
    }
    private void setWorkerManager() {
        Constraints constraints=new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        OneTimeWorkRequest oneTimeWorkRequest=new OneTimeWorkRequest.Builder(CaptureAnalyticsWork.class).setConstraints(constraints).build();
        WorkManager.getInstance().enqueue(oneTimeWorkRequest);
    }




}