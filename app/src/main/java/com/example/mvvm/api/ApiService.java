package com.example.mvvm.api;

import com.example.mvvm.model.Post;
import com.example.mvvm.model.response.LoginResponse;

import java.util.ArrayList;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("posts")
    Single<ArrayList<Post>> getListPosts();

    @POST("/api/auths/customer/login")
    Single<LoginResponse> login(@Body RequestBody loginResponse);
}
