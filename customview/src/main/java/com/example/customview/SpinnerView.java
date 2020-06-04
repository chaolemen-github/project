package com.example.customview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpinnerView extends RelativeLayout {

    private ImageView iv_img;
    private EditText et_content;
    private ArrayList<String> list;
    private PopupWindow pop;

    public SpinnerView(Context context) {
        super(context);
    }

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        initData();
        initView();

    }

    private void initData() {
        list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_spinner, null);
        this.addView(inflate);
        iv_img = inflate.findViewById(R.id.iv_arrow);
        et_content = inflate.findViewById(R.id.et_content);

        iv_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPop();
            }
        });
    }

    private void showPop() {

        if (pop==null) {
            pop = new PopupWindow(et_content.getWidth(), 600);

        ListView listView = new ListView(getContext());
        listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list.get(position);
                et_content.setText(s);
                et_content.setSelection(s.length());
                pop.dismiss();
            }
        });

        pop.setContentView(listView);
        pop.setBackgroundDrawable(new ColorDrawable());
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        }
        pop.showAsDropDown(et_content);
    }
}
