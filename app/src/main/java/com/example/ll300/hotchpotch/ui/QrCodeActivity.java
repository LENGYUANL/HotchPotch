package com.example.ll300.hotchpotch.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ll300.hotchpotch.R;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

/**
 * Created by ll300 on 2017/11/26.
 * 生成二维码
 */

public class QrCodeActivity extends BaseActivity {
    //我的二维码
    private ImageView iv_qr_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        initView();
    }

    private void initView() {

        iv_qr_code = (ImageView) findViewById(R.id.iv_qr_code);
        //屏幕的宽
        int width = getResources().getDisplayMetrics().widthPixels;

        Bitmap qrCodeBitmap = EncodingUtils.createQRCode("https://www.baidu.com", width / 2, width / 2,
                BitmapFactory.decodeResource(getResources(), R.drawable.favorite));
        iv_qr_code.setImageBitmap(qrCodeBitmap);
    }
}
