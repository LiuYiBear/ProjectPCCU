package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class set_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_login);

        Button button=(Button) findViewById(R.id.registered_btn);

        Button nextig =( Button)findViewById(R.id.registered_btn);
        nextig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set_login.this,set_registered.class);
                startActivity(intent);
            }
        });
    }
}
