package com.example.taskworkbook3.common;

import android.app.Application;

public class CommonApp extends Application {

    private static CommonApp app;

    public CommonApp() {
        app = this;
    }

    public static CommonApp getApp() {
        return app;
    }
}
