package com.example.aadpracticeproject;

public class TopIQ {
    private String mName;
    private int mHours;
    private String mCountry;

    public TopIQ(){}

    public TopIQ(String name, int hours, int skills, String country){
        this.mName = name;
        this.mHours = hours;
        this.mCountry = country;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getHours() {
        return mHours;
    }

    public void setHours(int hours) {
        mHours = hours;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }
}
