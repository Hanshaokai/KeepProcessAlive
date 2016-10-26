package com.example.han.keepprocessalive;

import android.app.Application;
import android.util.Log;

/**
 * Created by ${han} on 2016/10/26.
 */

public class DaemonApplication extends Application {
    private static int a = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("tag", "Application第" + ++a + "次初始化");

    }
}
