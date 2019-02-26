package com.max.mvvmarch;

import android.app.Application;

import com.max.core.CoreManager;

public class MvvmApplication extends Application {

    private static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        CoreManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Application getContext() {
        return mApplication;
    }
}
