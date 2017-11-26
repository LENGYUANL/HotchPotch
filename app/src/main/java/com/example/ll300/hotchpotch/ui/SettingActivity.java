package com.example.ll300.hotchpotch.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ll300.hotchpotch.R;
import com.example.ll300.hotchpotch.utils.ShareUtils;
import com.xys.libzxing.zxing.activity.CaptureActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private Switch sw_speak;
    //扫描二维码
    private LinearLayout ll_scan;
    //扫描的结果
    private TextView tv_scanresult;
    //生成二维码
    private LinearLayout ll_qr_code;
    //我的位置
    private LinearLayout ll_loaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
    }

    private void initView() {
        sw_speak = (Switch) findViewById(R.id.sw_speak);
        sw_speak.setOnClickListener(this);

        boolean isSpeak = ShareUtils.getBoolean(this, "isSpeak", false);
        sw_speak.setChecked(isSpeak);

        ll_scan = (LinearLayout) findViewById(R.id.ll_scan);
        ll_scan.setOnClickListener(this);

        tv_scanresult = (TextView) findViewById(R.id.tv_scanresult);
        ll_qr_code = (LinearLayout) findViewById(R.id.ll_qr_code);
        ll_qr_code.setOnClickListener(this);

        ll_loaction = (LinearLayout) findViewById(R.id.ll_my_location);
        ll_loaction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sw_speak:
                //切换状态
                sw_speak.setSelected(!sw_speak.isSelected());
                //保存状态
                ShareUtils.putBoolean(this, "isSpeak", sw_speak.isChecked());
                break;
            case R.id.ll_scan:
                Intent openCameraIntent = new Intent(this, CaptureActivity.class);
                startActivityForResult(openCameraIntent,0);
                break;
            case R.id.ll_qr_code:
                startActivity(new Intent(this, QrCodeActivity.class));
                break;
            case R.id.ll_my_location:
                startActivity(new Intent(this, LocationActivity.class));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            tv_scanresult.setText(scanResult);
        }
    }
}
