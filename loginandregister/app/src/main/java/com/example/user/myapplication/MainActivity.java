package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate (Bundle savedInstanceState){
        ThemeUtil.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // 視點是首頁

        Button button = (Button) findViewById(R.id.bt10);
        Button button2 = (Button) findViewById(R.id.bt11);
        Button button1 = (Button) findViewById(R.id.bt12);
        Button button3 = (Button) findViewById(R.id.bt13);
        //Button button5 = (Button) findViewById(R.id.bt14);







        Button nextig3 = (Button) findViewById(R.id.bt13);
        nextig3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, set.class);
                startActivity(intent);
            }
        });


        // Button nextig5 = (Button) findViewById(R.id.bt14);
        // nextig5.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //  public void onClick(View v) {
        //     Intent intent = new Intent();
        //     intent.setClass(MainActivity.this, talk.class);
        //    startActivity(intent);
        // }
        //});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.testmenu,menu);
        return true;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

}
