package com.baidu.ocr.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initView();
        Intent intent = getIntent();

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("result"));

            JSONArray array = jsonObject.getJSONArray("words_result");

            String lines = "";
            for(int i=0;i<array.length();++i){
                lines += (array.getJSONObject(i)).getString("words");
            }
            tv.setText(lines);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void initView(){
        tv = findViewById(R.id.result);

    }
}
