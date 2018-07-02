package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class yule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yule);

        ImageButton imageButton=(ImageButton) findViewById(R.id.imageButton3);

        ImageButton nextig =(ImageButton)findViewById(R.id.imageButton3);
        nextig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(yule.this,home_page.class);
                startActivity(intent);
            }
        });
    }
}
