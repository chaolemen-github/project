package com.example.taskworkbook8.presenter;

import com.example.taskworkbook8.bean.FoodBean;
import com.example.taskworkbook8.callBack.IFoodCallBack;
import com.example.taskworkbook8.model.FoodModel;
import com.example.taskworkbook8.view.IFoodView;

public class FoodPresenter implements IFoodPresenter, IFoodCallBack {

    private IFoodView view;
    private final FoodModel foodModel;

    public FoodPresenter(IFoodView view) {
        this.view = view;
        foodModel = new FoodModel();
    }

    @Override
    public void getData() {
        foodModel.getData(this);
    }

    @Override
    public void getSuccess(FoodBean foodBean) {
        view.getSuccess(foodBean);
    }

    @Override
    public void getError(String error) {
        view.getError(error);
    }
}
