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


        Button button1=(Button) findViewById(R.id.button17);

        Button nextig1 =( Button)findViewById(R.id.button17);
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
