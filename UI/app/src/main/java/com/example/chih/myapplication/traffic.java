package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class traffic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic);



        Button backig=(Button) findViewById(R.id.bt14);
        backig.setBackgroundResource(R.drawable.mainschoolbus);//title 置換圖片功能
        backig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.setClass(traffic.this,MainActivity.class);
                startActivity(intent);
            }
        });




        Button nextig1 =( Button)findViewById(R.id.gotaxi);
        nextig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(traffic.this,traffic_taxi.class);
                startActivity(intent);
            }
        });

        Button gobus =( Button)findViewById(R.id.gobus);
        gobus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(traffic.this,traffic_allbus.class);
                startActivity(intent);
            }
        });
    }
}
