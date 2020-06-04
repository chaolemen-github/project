package com.example.customview;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class DeleteView extends TextView {

    public DeleteView(Context context) {
        super(context);
    }

    public DeleteView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DeleteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDeleteLine(){
        getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
    }
}
