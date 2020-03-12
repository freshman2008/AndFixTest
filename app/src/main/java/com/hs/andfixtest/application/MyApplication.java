package com.hs.andfixtest.application;

import android.app.Application;

import com.example.fixlib.andfix.AndFixPatchManager;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //完成andFix初始化
        initAndFix();
    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }
}
