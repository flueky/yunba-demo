package com.flueky.demo;

import android.app.Application;

import io.yunba.android.manager.YunBaManager;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        YunBaManager.start(getApplicationContext());

    }
}
