package com.example.thjen.reminderdemo;

/**
 * Created by thjen on 13/10/2017.
 */

public class SinhVien {

    private String mName;
    private int mBerthday;

    public SinhVien(String mName, int mBerthday) {

        this.mName = mName;
        this.mBerthday = mBerthday;

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmBerthday() {
        return mBerthday;
    }

    public void setmBerthday(int mBerthday) {
        this.mBerthday = mBerthday;
    }

}
