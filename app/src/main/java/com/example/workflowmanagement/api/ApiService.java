package com.example.workflowmanagement.api;

import com.example.workflowmanagement.model.LoginReponse;
import com.example.workflowmanagement.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH-mm-ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @POST("user")
    Call<User> register(@Body User user);

    @POST("save")
    Call<LoginReponse> getListUser(@Body User user);
}
