package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class yule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yule);
        Button nextig=(Button)findViewById(R.id.button14);
        nextig.setBackgroundResource(R.drawable.yule1);//title 置換圖片功能
        nextig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.setClass(yule.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
