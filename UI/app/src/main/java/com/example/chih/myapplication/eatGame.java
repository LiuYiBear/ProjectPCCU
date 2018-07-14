package com.example.chih.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//public class eatGame extends AppCompatActivity {//extends AppCompatActivity 代表擴充AppCompatActivity
//    @Override//檢查是否有重複
//    protected void onCreate(Bundle savedInstanceState) {
//        //Bundle savedInstanceState經常會出現用戶按到home鍵，退出了介面，
//        // 或者安卓系統意外回收了應用的進程，這種情況下，
//        // 使用Bundle savedInstanceState就可以用戶再次打開應用的時候恢復的原來的狀態。
//        super.onCreate(savedInstanceState);//super代表調用付類屬性或方法，oncreate代表对界面的图画绘制工作。
//        setContenView(R.layout.eat_store_game);
//        Button storeSelect = (Button) findViewByld(R.id.storeSelect);
//        storeSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(eatGame.this, eatStoreDataGameSlect.class);
//                startActivity(intent);
//            }
//
//        });
//
//    }

//}