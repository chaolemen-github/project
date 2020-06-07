package com.example.exam6_5.view;

import com.example.exam6_5.bean.FoodBean;

public interface IFoodView {

    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
