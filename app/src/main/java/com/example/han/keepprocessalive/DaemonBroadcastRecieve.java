package com.example.han.keepprocessalive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ${han} on 2016/10/25.
 */

public class DaemonBroadcastRecieve extends BroadcastReceiver{
    private boolean isFirst=true;
    @Override
    public void onReceive(Context context, Intent intent) {

        while (isFirst){

            while(true){

                try {
                    Thread.sleep(2000);
                    Log.i("hehe","DaemonBroadRecieve is onReceive");
                    context.startService(new Intent(context,RemoteService.class));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }




        }




    }
}
