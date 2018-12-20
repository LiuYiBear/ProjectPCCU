package com.example.chih.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class eat_store_data extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eat_store_data);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(eat_store_data.this,eat.class);
                startActivity(intent);
            }
        });


        // 取得 Intent 附帶的資料，改成文章網址存為 url
        Bundle args = this.getIntent().getExtras();
        String store_id=args.getString("store_id");//前面是擷取的json內容，後面是假如沒有就取的內容，現在設為空值
        String store_name=args.getString("store_name");//前面是擷取的json內容，後面是假如沒有就取的內容，現在設為空值
        String store_phone=args.getString("store_phone");
        String store_address=args.getString("store_address");
        String store_menu_path=args.getString("store_menu_path");
        String store_photo_path=args.getString("store_photo_path");

        TextView storeName=(TextView)findViewById(R.id.storeName);
        TextView storePhone=(TextView)findViewById(R.id.storePhone);
        TextView storeAddress=(TextView)findViewById(R.id.storeAddress);

        ImageView imageView1 = (ImageView) findViewById(R.id.storeImage);
        String uri = "@drawable/" + store_photo_path;
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable image = getResources().getDrawable(imageResource);
        imageView1.setImageDrawable(image);

        storeName.setText(store_name);
        storePhone.setText(store_phone);
        storeAddress.setText(store_address);
        Log.d("TAG", store_name+store_address+store_phone+store_photo_path);
        // 取得XML中的TextView，設定文字為 url

    }

}
