package com.example.ll300.hotchpotch.application;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.example.ll300.hotchpotch.utils.StaticClass;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

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

        // 将“12345678”替换成您申请的APPID，申请地址：http://www.xfyun.cn
        // 请勿在“=”与appid之间添加任何空字符或者转义符
        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID +"=" + StaticClass.VOICE_KEY);

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
    }

}
