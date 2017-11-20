package com.example.ll300.hotchpotch.application;

import android.app.Application;

import com.example.ll300.hotchpotch.utils.StaticClass;

import cn.bmob.v3.Bmob;

/**
 * Created by ll300 on 2017/11/18.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化Bugly

        //初始化Bmob
        Bmob.initialize(this, StaticClass.BMOB_APPLICATION_ID);
    }

}
