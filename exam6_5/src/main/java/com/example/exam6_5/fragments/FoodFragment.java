package com.example.exam6_5.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.exam6_5.R;
import com.example.exam6_5.adapter.FoodAdapter;
import com.example.exam6_5.bean.FoodBean;
import com.example.exam6_5.presenter.FoodPresenter;
import com.example.exam6_5.view.IFoodView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

public class FoodFragment extends Fragment implements IFoodView {
    private static final String TAG = "FoodFragment";
    private int cid;
    private RecyclerView mRecyclerFood;
    private FoodPresenter foodPresenter;
    private FoodAdapter foodAdapter;
    private List<FoodBean.DataBean.DatasBean> data;
    private SmartRefreshLayout mSmart;
    int count = 1;

    public FoodFragment(int cid) {
        this.cid = cid;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_layout, container, false);
        foodPresenter = new FoodPresenter(this);
        initView(inflate);
        initPresenter();
        return inflate;
    }

    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && foodAdapter != null && mRecyclerFood != null) {
            initPresenter();
        }
    }

    //调用mvp的presenter的方法
    private void initPresenter() {
        foodPresenter.getData(cid, count);
    }

    private void initView(@NonNull final View itemView) {
        mRecyclerFood = (RecyclerView) itemView.findViewById(R.id.food_recycler);
        mSmart = (SmartRefreshLayout) itemView.findViewById(R.id.smart);
        mRecyclerFood.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerFood.addItemDecoration(new DividerItemDecoration(getActivity(), RecyclerView.VERTICAL));

        data = new ArrayList<>();
        foodAdapter = new FoodAdapter(getActivity(), data);
        mRecyclerFood.setAdapter(foodAdapter);

        //加载更多
        mSmart.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                count++;
                initPresenter();
            }

            //刷新
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                count = 1;
                initPresenter();
            }
        });
    }

    @Override
    public void getSuccess(FoodBean foodBean) {
        List<FoodBean.DataBean.DatasBean> datas = foodBean.getData().getDatas();
        if (count == 1) {
            data.clear();
            data.addAll(datas);
            foodAdapter.notifyDataSetChanged();
            mSmart.finishRefresh();
        } else {
            data.addAll(datas);
            foodAdapter.notifyDataSetChanged();
            mSmart.finishLoadmore();
        }

    }

    @Override
    public void getError(String error) {
        Log.e(TAG, "getError: 错误信息：" + error);
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
