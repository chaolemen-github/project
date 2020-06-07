package com.example.exam6_5.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.exam6_5.R;
import com.example.exam6_5.bean.FoodBean;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context context;
    List<FoodBean.DataBean.DatasBean> data;

    //有参构造
    public FoodAdapter(Context context, List<FoodBean.DataBean.DatasBean> data) {
        this.context = context;
        this.data = data;
    }

    //设置布局
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_layout_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    //适配数据
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        FoodBean.DataBean.DatasBean datasBean = data.get(i);

        RequestOptions circleCrop = new RequestOptions().circleCrop();

        RoundedCorners roundedCorners = new RoundedCorners(20);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);

        //3的倍数圆形图片
        if (datasBean.getId()%3==0){
            Glide.with(context).load(datasBean.getEnvelopePic()).apply(circleCrop).into(viewHolder.img);
        } else {
            //不是3的倍数圆角
            Glide.with(context).load(datasBean.getEnvelopePic()).apply(options).into(viewHolder.img);
        }
        viewHolder.title.setText(datasBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.food_img);
            title = itemView.findViewById(R.id.food_title);
        }
    }
}
