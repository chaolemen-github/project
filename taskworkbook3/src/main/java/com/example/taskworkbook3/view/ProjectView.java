package com.example.taskworkbook3.view;

import com.example.taskworkbook3.base.BaseView;
import com.example.taskworkbook3.bean.ProjectBean;

public interface ProjectView extends BaseView<ProjectBean> {
    void onSuccess(ProjectBean projectBean);
    void onFile(String error);
}
