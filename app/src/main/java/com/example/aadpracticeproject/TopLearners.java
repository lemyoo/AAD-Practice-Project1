package com.example.aadpracticeproject;

public class TopLearners {
    private String mName;
    private int mHours;
    private String mCountry;

    public TopLearners() {}

    public TopLearners(String name, int hours,String country) {
        this.mName = name;
        this.mHours = hours;
        this.mCountry = country;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public int getHours() {
        return mHours;
    }

    public void setHours(int hours) {
        mHours = hours;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
