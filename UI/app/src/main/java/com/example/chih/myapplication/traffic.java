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



        Button button=(Button) findViewById(R.id.back);

        Button nextig =( Button)findViewById(R.id.back);
        nextig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(traffic.this,home_page.class);
                startActivity(intent);
            }
        });



        Button button1=(Button) findViewById(R.id.btn17);

        Button nextig1 =( Button)findViewById(R.id.btn17);
        nextig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(traffic.this,traffic_taxi.class);
                startActivity(intent);
            }
        });
    }
}
