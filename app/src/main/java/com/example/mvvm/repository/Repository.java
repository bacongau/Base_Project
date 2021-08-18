package com.example.mvvm.repository;


import com.example.mvvm.api.ApiClient;
import com.example.mvvm.api.ApiService;
import com.example.mvvm.model.Post;
import com.example.mvvm.model.response.LoginResponse;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class Repository {
    private final ApiService apiService;

    public Repository() {
        this.apiService = ApiClient.getInstance().getApiService();
    }

    public Single<ArrayList<Post>> getPost() {
        return apiService.getListPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<LoginResponse> login(RequestBody loginResponse){
        return apiService.login(loginResponse)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
