package com.hs.andfixtest.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class Utils {
    public static String getVersionName(Context context) {
        String versionNumber = "1.0.0";
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionNumber = packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionNumber;
    }

    public static void printLog() {
        String error = null;
        Log.i("hello", error);
    }
}
