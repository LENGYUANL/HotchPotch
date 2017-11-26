package com.example.ll300.hotchpotch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ll300.hotchpotch.R;
import com.example.ll300.hotchpotch.entity.GirlData;
import com.example.ll300.hotchpotch.utils.PicassoUtils;

import java.util.List;

/**
 * Created by ll300 on 2017/11/25.
 */

public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private List<GirlData> mList;
    private GirlData data;
    private LayoutInflater inflater;
    //屏幕宽度
    private int width,height;
    private WindowManager wm;

    public GridAdapter(Context mContext, List<GirlData> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.girl_item,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        data = mList.get(position);
        //解析图片
        String url = data.getImgUrl();
        PicassoUtils.loadImageViewSize(mContext,url,width/2,height/6,viewHolder.imageView);
        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;
    }
}
