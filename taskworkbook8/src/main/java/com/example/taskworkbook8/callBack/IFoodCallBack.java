package com.example.taskworkbook8.callBack;

import com.example.taskworkbook8.bean.FoodBean;

public interface IFoodCallBack {
    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
