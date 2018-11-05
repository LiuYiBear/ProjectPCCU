package com.example.chih.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;
//import android.net.Uri;
import android.widget.TextView;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity  {
//public class MainActivity extends AppCompatActivity implements View.OnClickListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button button = (Button) findViewById(R.id.bt10);
        Button button2 = (Button) findViewById(R.id.bt11);
        Button button1 = (Button) findViewById(R.id.bt12);
        Button button3 = (Button) findViewById(R.id.bt13);
        Button button5 = (Button) findViewById(R.id.bt14);

        /*button.setOnClickListener(this);
        button.setTag(1);
        button2.setOnClickListener( this);
        button2.setTag(2);*/



            Button nextig =( Button)findViewById(R.id.bt10);
            nextig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,eat.class);
                    startActivity(intent);

                }
            });


            Button nextig1 =( Button)findViewById(R.id.bt12);
            nextig1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,playfun.class);
                    startActivity(intent);
                }
            });



            Button nextig2 =( Button)findViewById(R.id.bt11);
            nextig2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,traffic.class);
                    startActivity(intent);
                }
            });



            Button nextig3 =( Button)findViewById(R.id.bt13);
            nextig3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,set.class);
                    startActivity(intent);
                }
            });



            Button nextig5 =( Button)findViewById(R.id.bt14);
            nextig5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,talk.class);
                    startActivity(intent);
                }
            });
}

   /* public void onClick(View v) {
        int tag = (Integer) v.getTag();
        switch (tag) {
            case 1:
                Intent music = new Intent(Intent.ACTION_GET_CONTENT);
                music.setType("audio/*");
                startActivity(Intent.createChooser(music, "Select music"));
                break;
            case 2:
                Intent dial = new Intent();
                dial.setAction("android.intent.action.CALL");
                dial.setData(Uri.parse("tel:13428720000"));
                startActivity(dial);
                break;
            default:
                break;
        }
    }*/
  }

