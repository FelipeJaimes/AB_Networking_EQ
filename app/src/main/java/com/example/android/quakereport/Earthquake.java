package com.example.android.quakereport;

/**
 * Created by Felipe on 2/12/2018.
 */

public class Earthquake {

    private double mMagnitude;

    private String mLocation;

    private long mDate;

    private String mUrl;

    public Earthquake(double magnitude, String location, long date, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;

    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public long getmDate() {
        return mDate;
    }

    public void setmDate(long mDate) {
        this.mDate = mDate;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
