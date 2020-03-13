package com.hs.andfixtest.application;

import android.app.Application;

import com.example.fixlib.andfix.AndFixPatchManager;

import cn.jpush.android.api.JPushInterface;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //完成andFix初始化
        initAndFix();
        initJPush();
    }

    private void initJPush() {
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }
}
