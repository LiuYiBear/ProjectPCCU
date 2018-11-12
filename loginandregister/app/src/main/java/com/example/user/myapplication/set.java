package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class set extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtil.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);

        ImageButton imageButton=(ImageButton)findViewById(R.id.imageButton6);

        ImageButton nexting0=(ImageButton)findViewById(R.id.imageButton6);
        nexting0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //跳轉到說明
        Button button=(Button) findViewById(R.id.btn_1);

        Button nextig =( Button)findViewById(R.id.btn_1);
        nextig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_description.class);
                startActivity(intent);
            }
        });

        //跳轉到關於
        Button button2=(Button) findViewById(R.id.btn_2);

        Button nextig2 =( Button)findViewById(R.id.btn_2);
        nextig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_about.class);
                startActivity(intent);
            }
        });
        //跳轉到個人資料
        Button button3=(Button) findViewById(R.id.btn_3);

        Button nextig3 =( Button)findViewById(R.id.btn_3);
        nextig3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_information.class);
                startActivity(intent);
            }
        });

        //跳轉到布景
        Button button4=(Button) findViewById(R.id.btn_4);

        Button nextig4 =( Button)findViewById(R.id.btn_4);
        nextig4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_backgroundtheme.class);
                startActivity(intent);
            }
        });



        //跳轉到登入
        Button button6=(Button) findViewById(R.id.btn_6);

        Button nextig6 =( Button)findViewById(R.id.btn_6);
        nextig6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_login.class);
                startActivity(intent);
            }
        });
       /*  //跳轉到註冊
       Button button8=(Button) findViewById(R.id.btn_8);

        Button nextig8 =( Button)findViewById(R.id.btn_8);
        nextig8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,RegisterActivity.class);
                startActivity(intent);
            }
        });*/
       /*  註冊xml  button
        <Button
            android:id="@+id/btn_8"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="註冊" />
            // 登出的xml  button
              <Button
            android:id="@+id/btn_7"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="登出" />
            */
        //跳轉到app用戶反饋
        /*Button button5=(Button) findViewById(R.id.btn_5);

        Button nextig5 =( Button)findViewById(R.id.btn_5);
        nextig5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(set.this,set_usefeedback.class);
                startActivity(intent);
            }
        });*/
    }
}
