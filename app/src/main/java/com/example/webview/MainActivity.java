package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    private String myUrl = "https://iwop.github.io";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹뷰 셋팅!!

        //웹뷰를 XML에서 ID를 통해 가져옵니다!!
        mWebView = (WebView) findViewById(R.id.webvw);

        //자바스크립트를 허용시킵니다.
        mWebView.getSettings().setJavaScriptEnabled(true);

        //웹뷰를 실행시키는 코드입니다.
        mWebView.loadUrl(myUrl);

        //웹뷰에 크롬 사용을 허용하는 코드입니다. 이 부분이 없을 경우에 크롬에서 alert가 뜨지 않습니다.
        mWebView.setWebChromeClient(new WebChromeClient());

        //새창열기 없이 웹뷰 내에서 다시 열기 및 페이지 이동이 원활하기 위해 사용하는 코
        mWebView.setWebViewClient(new WebViewClientClass());

    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }
}