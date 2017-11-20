package com.example.ll300.hotchpotch.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ll300.hotchpotch.R;
import com.example.ll300.hotchpotch.utils.ShareUtils;
import com.example.ll300.hotchpotch.utils.StaticClass;

//闪屏页
public class SplashActivity extends AppCompatActivity {

    private TextView tv_splash;

    //闪屏页面的延时用handler实现
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case StaticClass.HANDLE_SPLASH:
                    if(isFirst()) {
                        Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }
        //这边还可以自定义字体，懒得下载就没写，功能函数已经写在UtilTools中了

    //初始化View
    private void initView() {
        tv_splash = (TextView) findViewById(R.id.tv_splash);

        //延时2000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLE_SPLASH,2000);

    }

    public boolean isFirst() {
        Boolean isfirst = ShareUtils.getBoolean(this,StaticClass.KEY_IS_FIRST, true);
        if(isfirst) {
            //标记我们启动过app
            ShareUtils.putBoolean(this,StaticClass.KEY_IS_FIRST,false);
            return true;
        }else {
            return false;
        }
    }
}
