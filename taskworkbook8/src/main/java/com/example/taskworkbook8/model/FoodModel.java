package com.example.taskworkbook8.model;

import com.example.taskworkbook8.api.ApiService;
import com.example.taskworkbook8.bean.FoodBean;
import com.example.taskworkbook8.callBack.IFoodCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodModel implements IFoodModel {
    @Override
    public void getData(final IFoodCallBack iFoodCallBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.food_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService apiService = build.create(ApiService.class);
        apiService.getFoodData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FoodBean foodBean) {
iFoodCallBack.getSuccess(foodBean);
                    }

                    @Override
                    public void onError(Throwable e) {
iFoodCallBack.getError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
