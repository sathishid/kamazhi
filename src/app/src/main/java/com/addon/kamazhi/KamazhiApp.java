package com.addon.kamazhi;

import android.app.Application;
import android.content.Context;

/**
 * Created by sathishbabur on 3/25/2017.
 */

public class KamazhiApp extends Application {
    private static Application myApplication;
    public static Application getMyApplication()
    {
        return myApplication;
    }
    public static Context getContext()
    {
        return getMyApplication().getApplicationContext();
    }
    @Override
    public void onCreate()
    {
        super.onCreate();
        myApplication=this;
    }
}
