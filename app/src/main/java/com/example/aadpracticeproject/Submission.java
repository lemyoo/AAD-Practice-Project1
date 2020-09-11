package com.example.aadpracticeproject;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class Submission {
    @SerializedName("entry.1877115667")
    private String firstName;

    @SerializedName("entry.2006916086")
    private String lastName;

    @SerializedName("entry.1824927963")
    private String emailAddress;

    @SerializedName("entry.284483984")
    private String linkProject;

    public Submission(String firstName, String lastName, String emailAddress, String linkProject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.linkProject = linkProject;
    }
}
