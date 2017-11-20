package com.example.ll300.hotchpotch.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by ll300 on 2017/11/18.
 */

public class UtilTools {

    public static void setFont(Context mcontext, TextView textView) {
        //设置字体，typeface用于加载资源文件
        Typeface fontType = Typeface.createFromAsset(mcontext.getAssets(),"fonts/Font.TTP");
        textView.setTypeface(fontType);
    }
}
