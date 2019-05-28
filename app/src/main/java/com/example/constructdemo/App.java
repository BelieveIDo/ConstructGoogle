package com.example.constructdemo;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    public static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        setAppContext(this.getApplicationContext());
        CrashHandler.init(mAppContext);
    }

    private static void setAppContext(Context mAppContext) {
        App.mAppContext = mAppContext;
    }
}
