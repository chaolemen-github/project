package com.example.exam6_5.api;

import com.example.exam6_5.bean.FoodBean;
import com.example.exam6_5.bean.TabBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String tabLayout_url = "https://www.wanandroid.com/";
    String food_url = "https://www.wanandroid.com/";

    @GET("project/tree/json")
    Observable<TabBean> getTabData();


    @GET("project/list/{count}/json")
    Observable<FoodBean> getFoodData(@Path("count") int count, @Query("cid") int cid);

}
