package com.example.chih.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_page);

            Button button=(Button) findViewById(R.id.bt10);

            Button nextig =( Button)findViewById(R.id.bt10);
            nextig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
<<<<<<< HEAD

            Button button1=(Button) findViewById(R.id.button12);
=======
            Button button1=(Button) findViewById(R.id.bt12);
>>>>>>> 554ae768086eec0141c7e7e66b54ec1e9a3b82e3

            Button nextig1 =( Button)findViewById(R.id.bt12);
            nextig1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,yule.class);
                    startActivity(intent);
                }
            });

<<<<<<< HEAD
            Button button2=(Button) findViewById(R.id.button11);

            Button nextig2 =( Button)findViewById(R.id.button11);
=======
            Button button2=(Button) findViewById(R.id.bt11);

            Button nextig2 =( Button)findViewById(R.id.bt11);
>>>>>>> 554ae768086eec0141c7e7e66b54ec1e9a3b82e3
            nextig2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,traffic.class);
                    startActivity(intent);
                }
            });

<<<<<<< HEAD
            Button button3=(Button) findViewById(R.id.button13);

            Button nextig3 =( Button)findViewById(R.id.button13);
=======
            Button button3=(Button) findViewById(R.id.bt13);

            Button nextig3 =( Button)findViewById(R.id.bt13);
>>>>>>> 554ae768086eec0141c7e7e66b54ec1e9a3b82e3
            nextig3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,set.class);
                    startActivity(intent);
                }
            });

<<<<<<< HEAD
=======
            Button button5=(Button) findViewById(R.id.bt14);

            Button nextig5 =( Button)findViewById(R.id.bt14);
            nextig5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,forum_article.class);
                    startActivity(intent);
                }
            });
>>>>>>> 554ae768086eec0141c7e7e66b54ec1e9a3b82e3
        }

    }