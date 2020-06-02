package com.example.taskworkbook3.net;

import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.load.HttpException;
import com.example.taskworkbook3.common.CommonApp;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class BaseObserver<T> extends ResourceSubscriber<T> {
    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onError(Throwable t) {
        Log.e("TAG", "error:" + t.getMessage());
        //对异常进行分类,不同的异常提示用户不同的信息
        if (t instanceof HttpException) {
            //   HTTP错误
            onFail("HTTP错误");
        } else if (t instanceof ConnectException
                || t instanceof UnknownHostException) {
            //   连接错误
            onFail("连接错误");
        } else if (t instanceof InterruptedIOException) {
            //  连接超时
            onFail("连接超时");
        } else if (t instanceof JsonParseException
                || t instanceof JSONException
                || t instanceof ParseException) {
            //  解析错误
            onFail("解析错误");
        } else {
            if (t != null) {
                onFail(t.toString());
            } else {
                onFail("未知错误");
            }
        }
    }
    protected void onFail(String error) {
        Toast.makeText(CommonApp.getApp(), error, Toast.LENGTH_SHORT).show();
    }



    @Override

    public void onComplete() {

    }
}
