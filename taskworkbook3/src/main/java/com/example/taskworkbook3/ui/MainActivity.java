package com.example.taskworkbook3.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.taskworkbook3.R;
import com.example.taskworkbook3.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();

        toolbar.setTitle("户外花朵识别系统");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));


    }

    @Override
    protected void initListener() {
        super.initListener();

        View headerView = navigation.getHeaderView(0);
        ImageView img = headerView.findViewById(R.id.header_img);
        TextView title = headerView.findViewById(R.id.header_title);
        TextView text = headerView.findViewById(R.id.header_text);
        title.setText("户外植物识别系统v1版");
        text.setText("让你快速知道植物信息");
//        RoundedCorners roundedCorners = new RoundedCorners(20);
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.transform(roundedCorners);
        RequestOptions requestOptions = new RequestOptions()
                .circleCrop();
        Glide.with(this).load(R.drawable.a13).apply(requestOptions).into(img);
    }
}
