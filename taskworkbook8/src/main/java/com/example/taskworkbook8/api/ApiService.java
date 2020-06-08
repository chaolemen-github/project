package com.example.taskworkbook8.api;

import com.example.taskworkbook8.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    String food_url = "https://api.yunxuekeji.cn/";

    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<FoodBean> getFoodData();
}
