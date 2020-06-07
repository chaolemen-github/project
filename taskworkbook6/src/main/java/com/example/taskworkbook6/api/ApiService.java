package com.example.taskworkbook6.api;

import com.example.taskworkbook6.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String food_url = "https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<FoodBean> getData();
}
