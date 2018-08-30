package analytics.client.capture.app.com.workmanger;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import analytics.capture.app.com.ICaptureAnalytics;
import analytics.client.capture.app.com.activity.MainActivity;
import androidx.work.Worker;

public class CaptureAnalyticsWork extends Worker {
    String Tag = MainActivity.class.getName();
    private String serverAppUri = "analytics.server.capture.app.com.analyticserverapp";
    private ICaptureAnalytics iCaptureAnalytics;

    @NonNull
    @Override
    public Result doWork() {
        if (appInstalledOrNot(serverAppUri)) {
            if (iCaptureAnalytics == null) {
                initConnection();
            }


        }
        return Worker.Result.SUCCESS;
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(Tag, "Service Connected");
            iCaptureAnalytics = ICaptureAnalytics.Stub.asInterface((IBinder) iBinder);
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
            Intent intent = new Intent(ICaptureAnalytics.class.getName());

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
}
