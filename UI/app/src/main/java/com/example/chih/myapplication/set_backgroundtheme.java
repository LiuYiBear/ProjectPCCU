package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class set_backgroundtheme extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtil.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_backgroundtheme);

        findViewById(R.id.tv_light).setOnClickListener(this);
        findViewById(R.id.tv_dark).setOnClickListener(this);
        //findViewById(R.id.tv_pink).setOnClickListener(this);
        // findViewById(R.id.tv_intent).setOnClickListener(this);


        Button button1 = (Button) findViewById(R.id.button18);

        Button nextig1 = (Button) findViewById(R.id.button18);
        nextig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(set_backgroundtheme.this, set.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {  //使用switch來換背景因為用布林值判斷所以只有ture跟false
            case R.id.tv_light:
                PrefsUtils.write(this, Config.THEME_CONFIG, true);
                ThemeUtil.reCreate(this);
                break;
            case R.id.tv_dark:
                PrefsUtils.write(this, Config.THEME_CONFIG, false);
                ThemeUtil.reCreate(this);
                break;
            /*case R.id.tv_pink:
                PrefsUtils.write(this, Config.THEME_CONFIG, false);
                ThemeUtil.reCreate(this);
                break;*/
           /* case R.id.tv_intent:
                Intent intent=new Intent(set_backgroundtheme.this,set.class);
                startActivity(intent);
                break;*/

        }

    }
}
