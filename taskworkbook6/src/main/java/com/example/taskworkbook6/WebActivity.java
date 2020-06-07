package com.example.taskworkbook6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView mWebView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webView);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        String title = getIntent().getStringExtra("title");
        mWebView.loadUrl("https://www.baidu.com");
        mWebView.setWebViewClient(new WebViewClient());

        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
    }
}
