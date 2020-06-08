package com.example.taskworkbook8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taskworkbook8.adapter.FoodAdapter;
import com.example.taskworkbook8.bean.FoodBean;
import com.example.taskworkbook8.presenter.FoodPresenter;
import com.example.taskworkbook8.view.IFoodView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IFoodView {
    private static final String TAG = "MainActivity";
    private Toolbar mToolbar;
    private RecyclerView mRecycler;
    private List<FoodBean.BodyBean.ResultBean> result;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPresenter();
    }

    private void initPresenter() {
        FoodPresenter foodPresenter = new FoodPresenter(this);
        foodPresenter.getData();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        mToolbar.setTitle("名师推荐");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = (TextView) mToolbar.getChildAt(0);
        textView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        textView.setGravity(Gravity.CENTER_HORIZONTAL);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));

        result = new ArrayList<>();
        foodAdapter = new FoodAdapter(this, result);
        mRecycler.setAdapter(foodAdapter);

    }

    @Override
    public void getSuccess(FoodBean foodBean) {
        List<FoodBean.BodyBean.ResultBean> results = foodBean.getBody().getResult();
        result.addAll(results);
        foodAdapter.notifyDataSetChanged();
    }

    @Override
    public void getError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        Log.e(TAG, "getError: "+error);
    }
}
