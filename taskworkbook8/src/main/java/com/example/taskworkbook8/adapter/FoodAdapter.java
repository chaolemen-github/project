package com.example.taskworkbook8.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.taskworkbook8.R;
import com.example.taskworkbook8.bean.FoodBean;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context context;
    List<FoodBean.BodyBean.ResultBean> result;


    public FoodAdapter(Context context, List<FoodBean.BodyBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_main_item, viewGroup, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FoodBean.BodyBean.ResultBean resultBean = result.get(i);
        viewHolder.mNameFood.setText(resultBean.getTeacherName());
        viewHolder.mTitleFood.setText(resultBean.getTitle());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(resultBean.getTeacherPic()).apply(requestOptions).into(viewHolder.mImgFood);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgFood;
        private TextView mNameFood;
        private TextView mTitleFood;
        private Button mBtnFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgFood = (ImageView) itemView.findViewById(R.id.food_img);
            mNameFood = (TextView) itemView.findViewById(R.id.food_name);
            mTitleFood = (TextView) itemView.findViewById(R.id.food_title);
            mBtnFood = (Button) itemView.findViewById(R.id.food_btn);
        }
    }
}
