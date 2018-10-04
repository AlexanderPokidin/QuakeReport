package com.example.android.quakereport;


public class Earthquake {

    private String mMag;
    private String mCity;
    private long mTimeInMilliseconds;

    public String getMag() {
        return mMag;
    }

    public String getCity() {
        return mCity;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public Earthquake(String mag, String city, long timeInMilliseconds) {

        mMag = mag;
        mCity = city;
        mTimeInMilliseconds = timeInMilliseconds;
    }
}
