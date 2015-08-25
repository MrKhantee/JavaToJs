package com.hxy.JavaToJs;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.webkit.WebView;


public class HTMLActivity extends Activity {
    private WebView webView=null;
    public Handler handler=new Handler();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        webView=(WebView)this.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("gbk");
        webView.addJavascriptInterface(new MyObject(this,handler),"myObject");
        String url="file:///android_asset/index.html";
        //webView.loadUrl(url);
        //webView.loadUrl("file:///android_asset/taobao.html");
        webView.loadUrl("http://h5.m.taobao.com/#index");
    }
}
