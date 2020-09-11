package com.example.aadpracticeproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionActivity extends AppCompatActivity {


    private String mFirstName;
    private String mLastName;
    private EditText mTextFirstName;
    private EditText mTextEmailAddress;
    private EditText mTextLastName;
    private EditText mTextGithubAddress;
    private String mEmailAddress;
    private String mGithubAddress;
    private Call<Void> mCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setIcon(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubmissionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mTextFirstName = (EditText) findViewById(R.id.text_first_name);
        mTextLastName = (EditText) findViewById(R.id.text_last_name);
        mTextEmailAddress = (EditText) findViewById(R.id.text_email_address);
        mTextGithubAddress = (EditText) findViewById(R.id.text_github_address);

        Button buttonSubmit = (Button) findViewById(R.id.button_submit);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        mCall = jsonPlaceHolderApi.createPost();


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstName = mTextFirstName.getText().toString();
                mLastName = mTextLastName.getText().toString();
                mEmailAddress = mTextEmailAddress.getText().toString();
                mGithubAddress = mTextGithubAddress.getText().toString();

                sendData(mFirstName,mLastName,mEmailAddress,mGithubAddress,v);
                Snackbar.make(v, mFirstName + mLastName+mEmailAddress+mGithubAddress,Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });


    }

    private void sendData(String firstName, String lastName, String emailAddress, String githubAddress, final View view) {
        mCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                Snackbar.make(view, throwable.getMessage(),Snackbar.LENGTH_LONG).show();
            }
        });
    }

}