package com.example.ll300.hotchpotch.entity;

import cn.bmob.v3.BmobUser;

/**
 * Created by ll300 on 2017/11/19.
 */

public class MyUser extends BmobUser {

    private int age;
    private boolean sex;
    private String desc;

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
