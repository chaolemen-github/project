package com.example.taskworkbook3.base;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter {
    private BaseView view;
    List<BaseModel> models = new ArrayList<>();

    public void setView(BaseView view) {
        this.view = view;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void onDestroy(){
        view=null;
        if (models.size()>0){
            for (BaseModel model : models) {
                model.onDestroy();
            }
            models.clear();
        }
    }

    protected void addModel(BaseModel model){
        models.add(model);
    }
}
