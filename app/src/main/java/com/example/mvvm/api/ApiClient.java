package com.example.mvvm.api;

import com.example.mvvm.App;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kidd on 26/03/2018.
 */
public class ApiClient {

    private static final String URL = "https://jsonplaceholder.typicode.com/";

    private final ApiService apiService;

    private static ApiClient singleton;

    private ApiClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        OkHttpClient client = builder.addInterceptor(new ConnectivityInterceptor(App.getInstance()))
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        apiService = mRetrofit.create(ApiService.class);
    }

    public static ApiClient getInstance() {
        if (singleton == null) {
            synchronized (ApiClient.class) {
                if (singleton == null) {
                    singleton = new ApiClient();
                }
            }
        }
        return singleton;
    }

    public ApiService getApiService() {
        return apiService;
    }

}
