package com.max.baselib.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public class VersionUtil {

    public static int buildVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public static int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}