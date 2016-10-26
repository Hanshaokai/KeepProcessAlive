package com.example.han.keepprocessalive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ${han} on 2016/10/25.
 */

public class RemoteBroadcastRecieve extends BroadcastReceiver {

    boolean isFirst = true;

    @Override
    public void onReceive(final Context context, Intent intent) {


        if (isFirst) {
            isFirst = false;
            while (true) {
                try {
                    Thread.sleep(2000);
                    context.startService(new Intent(context, DaemonService.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
