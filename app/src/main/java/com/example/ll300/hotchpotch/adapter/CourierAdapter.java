package com.example.ll300.hotchpotch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ll300.hotchpotch.R;
import com.example.ll300.hotchpotch.entity.CourierData;

import java.util.List;

/**
 * Created by ll300 on 2017/11/20.
 */

public class CourierAdapter extends BaseAdapter {

    private Context mContext;
    private List<CourierData> mList;
    //布局加载器
    private LayoutInflater inflater;
    private CourierData data;

    public CourierAdapter(Context mContext, List<CourierData> mList) {
        this.mContext = mContext;
        this.mList = mList;
        //获取系统服务
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        //第一次加载
        if(convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        }else {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_courier_item,null);
            viewHolder.tv_datetime = (TextView) convertView.findViewById(R.id.tv_datetime);
            viewHolder.tv_remark = (TextView) convertView.findViewById(R.id.tv_remark);
            viewHolder.tv_zone = (TextView) convertView.findViewById(R.id.tv_zone);
            //设置缓存
            convertView.setTag(viewHolder);
        }
        //设置数据
        data = mList.get(position);
        viewHolder.tv_datetime.setText(data.getDatetime());
        viewHolder.tv_remark.setText(data.getRemark());
        viewHolder.tv_zone.setText(data.getZone());
        return convertView;
    }
    class ViewHolder {
        private TextView tv_remark;
        private TextView tv_zone;
        private TextView tv_datetime;
    }
}
