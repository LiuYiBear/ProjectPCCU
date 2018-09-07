package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class set_usefeedback extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_usefeedback);

        Button button1=(Button) findViewById(R.id.btn_20);

        Button nextig1 =( Button)findViewById(R.id.btn_20);
        nextig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set_usefeedback.this,set.class);
                startActivity(intent);
            }
        });
    }
}
