package com.example.exam6_5.callBack;

import com.example.exam6_5.bean.FoodBean;

public interface IFoodCallBack {
    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
