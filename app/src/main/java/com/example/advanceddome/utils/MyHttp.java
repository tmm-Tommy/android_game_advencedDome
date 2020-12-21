package com.example.advanceddome.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MyHttp {
    private static RequestQueue queue;
    public static String HEAD_URL = "http://172.168.10.100:8085/";
    private static ProgressDialog progressDialog;

    public static void Call(final Context context, String url, boolean isLog, final Response.Listener<JSONObject> jsonObjectListener) {
        try {
            if (queue == null) {
                queue = Volley.newRequestQueue(context);
            }
            if (isLog) showView(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        queue.add(new JsonObjectRequest(HEAD_URL + url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    disView();
                    jsonObjectListener.onResponse(jsonObject);
                    Log.d("MyHttp", jsonObject.toString());
                } catch (Exception e) {
                    disView();
                    Toast.makeText(context, "服务器错误1", Toast.LENGTH_SHORT).show();
                    Log.d("MyHttp", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                disView();
                Toast.makeText(context, "服务器错误2", Toast.LENGTH_SHORT).show();
                Log.d("MyHttp", e.toString());
            }
        }));

    }

    public static void showView(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("正在加载...");
        progressDialog.show();
    }

    public static void disView() {
        try {
            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
