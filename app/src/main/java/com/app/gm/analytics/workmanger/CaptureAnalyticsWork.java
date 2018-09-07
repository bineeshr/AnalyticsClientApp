package com.app.gm.analytics.workmanger;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.app.gm.analytics.IAnalyticsInterface;
import com.app.gm.analytics.activity.MainActivity;



public class CaptureAnalyticsWork extends JobService {
    String Tag = MainActivity.class.getName();
    private String serverAppUri = "analytics.server.capture.app.com.analyticserverapp";
    private IAnalyticsInterface iCaptureAnalytics;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(Tag, "Service Connected");
            iCaptureAnalytics = IAnalyticsInterface.Stub.asInterface((IBinder) iBinder);
            Toast.makeText(getApplicationContext(), "SERVER CONNECTED", Toast.LENGTH_SHORT).show();
            try {
                Log.i("data", "" + iCaptureAnalytics.event("String data"));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(Tag, "Service Disconnected");
            iCaptureAnalytics = null;
        }
    };

    private void initConnection() {
        if (iCaptureAnalytics == null) {
            Intent intent = new Intent(IAnalyticsInterface.class.getName());

            /*this is service name*/
            intent.setAction("aidl_service_calc");

            /*From 5.0 annonymous intent calls are suspended so replacing with server app's package name*/
            intent.setPackage(serverAppUri);

            // binding to remote service
            getApplicationContext().bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
        }
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getApplicationContext().getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        if (appInstalledOrNot(serverAppUri)) {
            if (iCaptureAnalytics == null) {
                initConnection();
            }
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
