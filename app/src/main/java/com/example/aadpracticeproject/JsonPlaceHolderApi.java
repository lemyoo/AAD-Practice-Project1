package com.example.aadpracticeproject;

import retrofit2.Call;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Void> createPost();
}
