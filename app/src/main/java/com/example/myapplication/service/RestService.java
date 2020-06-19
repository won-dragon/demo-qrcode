package com.example.myapplication.service;


import android.util.Log;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RestService {
    private String url = "http://13.209.19.242:8081/qr-demo/api";

    public void postAction(String path, String message) {
        try{

            String [] dataArray = message.split("/");
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("userName", dataArray[0]);
                jsonObject.put("userHpNum", dataArray[1]);
                jsonObject.put("userEmail", dataArray[2]);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MediaType JSON
                    = MediaType.parse("application/json; charset=utf-8");
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = RequestBody.create(jsonObject.toString(),JSON);
            Request request = new Request.Builder()
                    .url(url + path)
                    .post(formBody)
                    .build();

            Call call = client.newCall(request);
            Response response = call.execute();
            Log.i("W",response.toString());

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
