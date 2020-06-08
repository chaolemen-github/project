package com.example.taskworkbook8.view;

import com.example.taskworkbook8.bean.FoodBean;

public interface IFoodView {
    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
