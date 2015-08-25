package com.hxy.JavaToJs;


import android.os.Handler;
import android.webkit.WebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xianyu.hxy on 2015/8/25.
 */
public class MyObject {
    private Handler handler=null;
    private WebView webView=null;
    public MyObject(HTMLActivity htmlActivity,Handler handler){
        this.webView=(WebView)htmlActivity.findViewById(R.id.webView);
        this.handler=handler;
    }
    public void init(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:setContactInfo('" + getJsonStr()
                        + "')");
            }
        });
    }
    public static String getJsonStr(){
        try {
            JSONObject object1 = new JSONObject();
            object1.put("id", 1);
            object1.put("name", "tom");
            object1.put("phone", "123456");

            JSONObject object2 = new JSONObject();
            object2.put("id", 2);
            object2.put("name", "cat");
            object2.put("phone", "456789");

            JSONArray jsonArray = new JSONArray();
            jsonArray.put(object1);
            jsonArray.put(object2);
            System.out.println(jsonArray.toString());
            return jsonArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
