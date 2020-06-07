package com.example.exam6_5.model;

import com.example.exam6_5.callBack.IFoodCallBack;

public interface IFoodModel {
    void getData(int cid,int count, IFoodCallBack foodCallBack);
}
