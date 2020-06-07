package com.example.exam6_5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.exam6_5.api.ApiService;
import com.example.exam6_5.bean.TabBean;
import com.example.exam6_5.fragments.FoodFragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TabLayout mTabLayout;
    private ViewPager mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        //获取tabLayout的数据
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.tabLayout_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getTabData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TabBean tabBean) {
                        List<TabBean.DataBean> data = tabBean.getData();

                        final ArrayList<Fragment> fragments = new ArrayList<>();
                        final ArrayList<String> titles = new ArrayList<>();
                        //创建相应的fragment
                        for (int i = 0; i < data.size(); i++) {
                            TabBean.DataBean dataBean = data.get(i);
                            fragments.add(new FoodFragment(dataBean.getId()));
                            titles.add(dataBean.getName());
                        }

                        //适配fragment
                        mFrameLayout.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                            @Override
                            public Fragment getItem(int i) {
                                return fragments.get(i);
                            }

                            @Override
                            public int getCount() {
                                return fragments.size();
                            }

                            @Nullable
                            @Override
                            public CharSequence getPageTitle(int position) {
                                return titles.get(position);
                            }
                        });

                        mTabLayout.setupWithViewPager(mFrameLayout);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mFrameLayout = (ViewPager) findViewById(R.id.frameLayout);
        //解决TabLayout的滑动问题
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
