package com.example.android.quakereport;


public class Earthquake {

    private String mMag;
    private String mCity;
    private String mDate;

    public String getMag() {
        return mMag;
    }

    public String getCity() {
        return mCity;
    }

    public String getDate() {
        return mDate;
    }

    public Earthquake(String mag, String city, String date) {

        mMag = mag;
        mCity = city;
        mDate = date;
    }
}
