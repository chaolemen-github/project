package com.example.exam6_5.model;

import com.example.exam6_5.api.ApiService;
import com.example.exam6_5.bean.FoodBean;
import com.example.exam6_5.callBack.IFoodCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodModel implements IFoodModel {
    //获取数据
    @Override
    public void getData(int cid,int count, final IFoodCallBack foodCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.food_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getFoodData(count,cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FoodBean foodBean) {
                        foodCallBack.getSuccess(foodBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        foodCallBack.getError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
