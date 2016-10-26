package com.example.han.keepprocessalive;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ${han} on 2016/10/25.
 */

public class RemoteService extends Service {
    private boolean isFirst = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("hehe", "RemoteService is on receive");
        //if (isFirst){
        // isFirst=false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            Notification.Builder builder = new Notification.Builder(this);

            builder.setSmallIcon(R.mipmap.ic_launcher);
            startForeground(111, builder.build());
        } else {
            startForeground(111, new Notification());
        }
        //RemoteService.this.sendBroadcast(new Intent(RemoteService.this,DaemonBroadcastRecievi.class));
        startService(new Intent(this, DaemonService.class));
        // sendBroadcast(new Intent(this,RemoteBroadcastRecive.class));
        //}

        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.i("hehe", "RemoteService is Destroy");
        super.onDestroy();
    }
}
