package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class set extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);

        //跳轉到說明
        Button button1=(Button) findViewById(R.id.button);

        Button nextig1 =( Button)findViewById(R.id.button);
        nextig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_description.class);
                startActivity(intent);
            }
        });

        //跳轉到關於
        Button button2=(Button) findViewById(R.id.button2);

        Button nextig2 =( Button)findViewById(R.id.button2);
        nextig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_about.class);
                startActivity(intent);
            }
        });
        //跳轉到個人資料
        Button button3=(Button) findViewById(R.id.button3);

        Button nextig3 =( Button)findViewById(R.id.button3);
        nextig3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_information.class);
                startActivity(intent);
            }
        });

        //跳轉到布景
        Button button4=(Button) findViewById(R.id.button4);

        Button nextig4 =( Button)findViewById(R.id.button4);
        nextig4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_backgroundtheme.class);
                startActivity(intent);
            }
        });

        //跳轉到用戶反饋
        Button button5=(Button) findViewById(R.id.button5);

        Button nextig5 =( Button)findViewById(R.id.button5);
        nextig5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_usefeedback.class);
                startActivity(intent);
            }
        });
    }
}