package analytics.client.capture.app.com.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import analytics.capture.app.com.R;
import analytics.capture.app.com.workmanger.CaptureAnalyticsWork;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType
                .CONNECTED).build();
         PeriodicWorkRequest.Builder photoCheckBuilder= new PeriodicWorkRequest.Builder(CaptureAnalyticsWork.class,1, TimeUnit.MILLISECONDS).setConstraints(constraints);
        PeriodicWorkRequest photoCheckWork = photoCheckBuilder.build();
        WorkManager.getInstance().enqueueUniquePeriodicWork(
                "ANALYTICS_DATA",
                ExistingPeriodicWorkPolicy.REPLACE, photoCheckWork);

    }



}
