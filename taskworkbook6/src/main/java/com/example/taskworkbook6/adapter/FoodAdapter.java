package com.example.taskworkbook6.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.taskworkbook6.R;
import com.example.taskworkbook6.bean.FoodBean;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter {

    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;

    Context context;
    List<FoodBean.DataBean.DatasBean> data;


    public FoodAdapter(Context context, List<FoodBean.DataBean.DatasBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i) {
            case TYPE_1:
                View inflate = LayoutInflater.from(context).inflate(R.layout.activity_main_item1, viewGroup, false);
                return new ViewHolder1(inflate);
            case TYPE_2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.activity_main_item2, viewGroup, false);
                return new ViewHolder2(inflate2);
            default:
                return null;
        }
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final FoodBean.DataBean.DatasBean datasBean = data.get(i);
        int itemViewType = getItemViewType(i);
        switch (itemViewType){
            case TYPE_1:
                ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
                viewHolder1.name.setText(datasBean.getChapterName());
                viewHolder1.time.setText(datasBean.getNiceDate());
                viewHolder1.title.setText(datasBean.getTitle());
                break;
            case TYPE_2:
                ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
                viewHolder2.name.setText(datasBean.getChapterName());
                viewHolder2.time.setText(datasBean.getNiceDate());
                viewHolder2.title.setText(datasBean.getTitle());
                Glide.with(context).load(datasBean.getEnvelopePic()).into(viewHolder2.img);
                break;
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItem!=null){
                    onClickItem.onClick(datasBean.getTitle());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView name,time,title;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item1_name);
            time = itemView.findViewById(R.id.item1_time);
            title = itemView.findViewById(R.id.item1_title);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name,time,title;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
             img = itemView.findViewById(R.id.item2_img);
             name = itemView.findViewById(R.id.item2_name);
             time = itemView.findViewById(R.id.item2_time);
             title = itemView.findViewById(R.id.item2_title);
        }
    }

    OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public interface OnClickItem{
        void onClick(String title);
    }
}
