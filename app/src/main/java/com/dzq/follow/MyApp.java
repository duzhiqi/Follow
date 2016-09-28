package com.dzq.follow;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by dzq on 2016/9/22.
 */

public class MyApp extends Application {
    private static MyApp myApp;

    public static Context getContext() {
        return myApp;
    }

    public static Context getInstance() {
        Log.e("dzq", "----------------myapp" + myApp.toString());
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }


}
