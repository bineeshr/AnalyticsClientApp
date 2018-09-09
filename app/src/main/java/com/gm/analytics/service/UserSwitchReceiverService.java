package analytics.client.capture.app.com.Service;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import analytics.client.capture.app.com.Receiver.UserSwitchReceiver;
import analytics.client.capture.app.com.util.AppUtil;




public class UserSwitchReceiverService extends Service{

    private String TAG = "UserSwitchReceiverService";

    private UserSwitchReceiver userSwitchReceiver = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: Sticky intent");
        return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_USER_BACKGROUND);
        intentFilter.setPriority(100);

        //userSwitchReceiver = new UserSwitchReceiver();
        //registerReceiver(userSwitchReceiver, intentFilter);

        userSwitchReceiver = new UserSwitchReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context,"Profile Switch. ACTION_USER_BACKGROUND!!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onReceive: User Switch Occurred ");
                AppUtil.scheduleJob(context);
            }
        };

        registerReceiver(userSwitchReceiver, intentFilter);

        Log.d(TAG, "onCreate: userSwitchReceiver is received");


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(userSwitchReceiver != null){
            unregisterReceiver(userSwitchReceiver);
            Log.d(TAG, "onDestroy: userSwitchReceiver is unregistered!!");
            userSwitchReceiver = null;
        }
    }
}
