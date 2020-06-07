package com.example.exam6_5.presenter;

import com.example.exam6_5.bean.FoodBean;
import com.example.exam6_5.callBack.IFoodCallBack;
import com.example.exam6_5.model.FoodModel;
import com.example.exam6_5.view.IFoodView;

public class FoodPresenter implements IFoodPresenter {

    private final FoodModel foodModel;
    private IFoodView iFoodView;

    public FoodPresenter(IFoodView iFoodView) {
        this.iFoodView = iFoodView;
        foodModel = new FoodModel();
    }

    //关联view和model
    @Override
    public void getData(int cid,int count) {
        foodModel.getData(cid, count,new IFoodCallBack() {
            @Override
            public void getSuccess(FoodBean foodBean) {
                iFoodView.getSuccess(foodBean);
            }

            @Override
            public void getError(String error) {
                iFoodView.getError(error);
            }
        });
    }
}
