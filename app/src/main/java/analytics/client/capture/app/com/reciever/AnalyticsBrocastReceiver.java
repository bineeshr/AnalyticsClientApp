package analytics.client.capture.app.com.reciever;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import analytics.client.capture.app.com.workmanger.CaptureAnalyticsWork;

public class AnalyticsBrocastReceiver extends BroadcastReceiver {
    private static final int JOB_ID_UPDATE = 0x1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        scheduleJob(context);

    }



    public static void scheduleJob(Context context) {
        ComponentName serviceComponent = new ComponentName(context, CaptureAnalyticsWork.class);
        JobInfo job =
                new JobInfo.Builder(JOB_ID_UPDATE,
                        serviceComponent).setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                        .setRequiresCharging(true)
                        .build();
        JobScheduler mJobService = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        mJobService.schedule(job);
    }


}