package com.example.taskworkbook3.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static volatile HttpManager ourInstance;

    public static HttpManager getInstance() {
        if (ourInstance == null) {
            synchronized (HttpManager.class) {
                if (ourInstance == null) {
                    ourInstance = new HttpManager();
                }
            }
        }
        return ourInstance;
    }

    private HttpManager() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());


    }

}
