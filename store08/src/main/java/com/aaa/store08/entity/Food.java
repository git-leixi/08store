package com.aaa.store08.entity;

import java.io.Serializable;

public class Food implements Serializable {
    private Integer mId;
    private String mName;
    private String mPrice;
    private String mImg;
    private Integer mKind;
    private Integer mArea;
    private String aName;
    private String aMain;
    private String kName;

    @Override
    public String toString() {
        return "Food{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mImg='" + mImg + '\'' +
                ", mKind=" + mKind +
                ", mArea=" + mArea +
                ", aName='" + aName + '\'' +
                ", aMain='" + aMain + '\'' +
                ", kName='" + kName + '\'' +
                '}';
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmImg() {
        return mImg;
    }

    public void setmImg(String mImg) {
        this.mImg = mImg;
    }

    public Integer getmKind() {
        return mKind;
    }

    public void setmKind(Integer mKind) {
        this.mKind = mKind;
    }

    public Integer getmArea() {
        return mArea;
    }

    public void setmArea(Integer mArea) {
        this.mArea = mArea;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaMain() {
        return aMain;
    }

    public void setaMain(String aMain) {
        this.aMain = aMain;
    }

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }
}
