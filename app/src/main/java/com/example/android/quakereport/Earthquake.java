package com.example.android.quakereport;


public class Earthquake {

    private double mMag;
    private String mCity;
    private long mTimeInMilliseconds;

    public double getMag() {
        return mMag;
    }

    public String getCity() {
        return mCity;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public Earthquake(double mag, String city, long timeInMilliseconds) {

        mMag = mag;
        mCity = city;
        mTimeInMilliseconds = timeInMilliseconds;
    }
}
