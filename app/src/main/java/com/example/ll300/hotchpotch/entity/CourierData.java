package com.example.ll300.hotchpotch.entity;

/**
 * Created by ll300 on 2017/11/20.
 */

public class CourierData {
    private String datetime;
    private String remark;
    private String zone;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
