package analytics.client.capture.app.com.util;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

import analytics.client.capture.app.com.workmanger.CaptureAnalyticsWork;

public class AppUtil {
    private static final int JOB_ID_UPDATE = 0x1000;

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
