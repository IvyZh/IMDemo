package com.example.ivy.imdemo;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by Ivy on 2016/7/26.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化融云
        RongIM.init(this);
        System.out.print("MyApplication onCreate...");
    }
}
