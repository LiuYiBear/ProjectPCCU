package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class traffic_taxi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_taxi);

        Button button1=(Button) findViewById(R.id.back);

        Button nextig1 =( Button)findViewById(R.id.back);
        nextig1.setBackgroundResource(R.drawable.trafficback);

        nextig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(traffic_taxi.this,traffic.class);
                startActivity(intent);
            }
        });
    }
}
