package com.example.android.quakereport;

/**
 * Created by Felipe on 2/12/2018.
 */

public class Earthquake {

    private double mMagnitude;

    private String mLocation;

    private long mDate;

    public Earthquake(double magnitude, String location, long date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;

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
}
