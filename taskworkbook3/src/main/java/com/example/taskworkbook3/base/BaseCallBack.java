package com.example.taskworkbook3.base;

public interface BaseCallBack<T> {
    void onSuccess(T t);
    void onFile(String error);
}
