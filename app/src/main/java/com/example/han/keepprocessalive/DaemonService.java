package com.example.han.keepprocessalive;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ${han} on 2016/10/25.
 */
public class DaemonService extends Service {
    private boolean isFirst = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("heheh", "DaemonService is onStartCommend");
        // if (isFirst){
        final Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        startForeground(111, builder.build());
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                stopForeground(true);
                NotificationManager manager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(111, builder.build());
            }
        }).start();
        //            isFirst = false;
        //        }
        //        sendBroadcast(new Intent(this,RemoteBroadcastRecieve.class));
        //        startService(new Intent(this,RemoteService.class));
        return START_STICKY;
    }

}
