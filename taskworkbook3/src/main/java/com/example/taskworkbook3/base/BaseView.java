package com.example.taskworkbook3.base;

public interface BaseView<T> {
    void onSuccess(T t);
    void onFile(String error);
}
