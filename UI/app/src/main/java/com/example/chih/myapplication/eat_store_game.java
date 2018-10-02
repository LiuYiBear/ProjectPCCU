package com.example.chih.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class eat_store_game extends AppCompatActivity {
    Button button;
    TextView textView;
    ImageView iv_wheel;
    Context context;

    Random r;

    int degree = 0, degree_old = 0;

    //because there is 37 sectors on the wheel (9.72 degrees each)
    private static final float FACTOR = 4.86f;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.eat_store_game);

        Button backig=(Button)findViewById(R.id.back);
        backig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.setClass(eat_store_game.this,eat.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.menuGameStar);
        textView = findViewById(R.id.textView8);
        iv_wheel = findViewById(R.id.iv_wheel);

        r = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //紀錄輪盤的度數
                degree_old = degree % 360;
                //輪盤的轉動度數
                degree = r.nextInt(3600) + 720;

                RotateAnimation rotate = new RotateAnimation(degree_old, degree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                // Animation : attributes
                // https://developer.android.com/reference/android/view/animation/Animation.html
                // 動畫執行時間
                rotate.setDuration(1000);
                // true : 動畫執行完畢後,View對象保留在終止的位置
                // false : 動畫執行完畢後,回復到最初狀態
                rotate.setFillAfter(true);
                //動畫速度由快到慢
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        textView.setText("");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {//輪盤轉完會執行的函式
                        textView.setText(currentNumber(360 - (degree % 360)));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                // 動畫開始
                iv_wheel.startAnimation(rotate);

            }
        });
    }

    private String currentNumber(int degrees) {
        String text = "";

        // do this for each of the numbers
        if (degrees >= (FACTOR * 1) && degrees < (FACTOR * 3)) {
            text = "32 red";
        }
        if (degrees >= (FACTOR * 3) && degrees < (FACTOR * 5)) {
            text = "15 black";
        }
        if (degrees >= (FACTOR * 5) && degrees < (FACTOR * 7)) {
            text = "19 red";
        }
        if (degrees >= (FACTOR * 7) && degrees < (FACTOR * 9)) {
            text = "4 black";
        }
        if (degrees >= (FACTOR * 9) && degrees < (FACTOR * 11)) {
            text = "21 red";
        }
        if (degrees >= (FACTOR * 11) && degrees < (FACTOR * 13)) {
            text = "2 black";
        }
        if (degrees >= (FACTOR * 13) && degrees < (FACTOR * 15)) {
            text = "25 red";
        }
        if (degrees >= (FACTOR * 15) && degrees < (FACTOR * 17)) {
            text = "17 black";
        }
        if (degrees >= (FACTOR * 17) && degrees < (FACTOR * 19)) {
            text = "34 red";
        }
        if (degrees >= (FACTOR * 19) && degrees < (FACTOR * 21)) {
            text = "6 black";
        }
        if (degrees >= (FACTOR * 21) && degrees < (FACTOR * 23)) {
            text = "21 red";
        }
        if (degrees >= (FACTOR * 23) && degrees < (FACTOR * 25)) {
            text = "13 black";
        }
        if (degrees >= (FACTOR * 25) && degrees < (FACTOR * 27)) {
            text = "36 red";
        }
        if (degrees >= (FACTOR * 27) && degrees < (FACTOR * 29)) {
            text = "11 black";
        }
        if (degrees >= (FACTOR * 29) && degrees < (FACTOR * 31)) {
            text = "30 red";
        }
        if (degrees >= (FACTOR * 31) && degrees < (FACTOR * 33)) {
            text = "8 black";
        }
        if (degrees >= (FACTOR * 33) && degrees < (FACTOR * 35)) {
            text = "23 red";
        }
        if (degrees >= (FACTOR * 35) && degrees < (FACTOR * 37)) {
            text = "10 black";
        }
        if (degrees >= (FACTOR * 37) && degrees < (FACTOR * 39)) {
            text = "5 red";
        }
        if (degrees >= (FACTOR * 39) && degrees < (FACTOR * 41)) {
            text = "24 black";
        }
        if (degrees >= (FACTOR * 41) && degrees < (FACTOR * 43)) {
            text = "16 red";
        }
        if (degrees >= (FACTOR * 43) && degrees < (FACTOR * 45)) {
            text = "33 black";
        }
        if (degrees >= (FACTOR * 45) && degrees < (FACTOR * 47)) {
            text = "1 red";
        }
        if (degrees >= (FACTOR * 47) && degrees < (FACTOR * 49)) {
            text = "20 black";
        }
        if (degrees >= (FACTOR * 49) && degrees < (FACTOR * 51)) {
            text = "14 red";
        }
        if (degrees >= (FACTOR * 51) && degrees < (FACTOR * 53)) {
            text = "31 black";
        }
        if (degrees >= (FACTOR * 53) && degrees < (FACTOR * 55)) {
            text = "9 red";
        }
        if (degrees >= (FACTOR * 55) && degrees < (FACTOR * 57)) {
            text = "22 black";
        }
        if (degrees >= (FACTOR * 57) && degrees < (FACTOR * 59)) {
            text = "18 red";
        }
        if (degrees >= (FACTOR * 59) && degrees < (FACTOR * 61)) {
            text = "29 black";
        }
        if (degrees >= (FACTOR * 61) && degrees < (FACTOR * 63)) {
            text = "7 red";
        }
        if (degrees >= (FACTOR * 63) && degrees < (FACTOR * 65)) {
            text = "28 black";
        }
        if (degrees >= (FACTOR * 65) && degrees < (FACTOR * 67)) {
            text = "12 red";
        }
        if (degrees >= (FACTOR * 67) && degrees < (FACTOR * 69)) {
            text = "35 black";
        }
        if (degrees >= (FACTOR * 69) && degrees < (FACTOR * 71)) {
            text = "3 red";
        }
        if (degrees >= (FACTOR * 71) && degrees < (FACTOR * 73)) {
            text = "26 black";
        }
        if ((degrees >= (FACTOR * 73) && degrees < 360) || (degrees >=0 && degrees < (FACTOR * 1))) {
            text = "0";
        }

        return text;
    }

    @Override
    protected void onResume() {
        super.onResume();
        context =this;
        final Button buttonStoreChose=(Button)findViewById(R.id.storeSelect);
        buttonStoreChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listGameStore=(ListView)findViewById(R.id.listGameStore);

                listGameStore.setVisibility(View.VISIBLE);


                eat_store_data_mylistview myAsyncTask=new eat_store_data_mylistview(context, new eat_store_data_mylistview.TaskListener() {
                    @Override
                    public void onFinished(String result) {
                        try{
                            if (result == null) {
                                Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            // 將由主機取回的字串轉為JSONArray
                            String tmp = result;//導入網頁字串放到tmp裡
                            ListView listAll=(ListView)findViewById(R.id.listGameStore);//绑定Layout里面的ListView
                            tmp = tmp.substring(tmp.indexOf("["), tmp.lastIndexOf("]") + 1);//做字串內容擷取
                            tmp = tmp.substring(0,tmp.length() - 2);
                            tmp=tmp+"]";
                            Log.d("TAG", tmp);
                            try {
                                try {
                                    final JSONArray array = new JSONArray(tmp);
                                    ArrayList<HashMap<String, String>> map = new ArrayList<>();
                                    JSONObject jsonObject=new JSONObject();
                                    for (int i = 0; i < array.length(); i++) {
                                        jsonObject = array.getJSONObject(i);
                                        HashMap<String,String> item = new HashMap<>();
                                        String store_name = jsonObject.getString("store_name");
                                        item.put("eatAdapterText1", store_name.toString());
                                        map.add(item);
                                    }
                                    //以下為適配器導入
                                    SimpleAdapter listItemAdapter = new SimpleAdapter(context,map,//数据源
                                            R.layout.eat_store_game_data_select,//ListItem的XML实现
                                            //动态数组与ImageItem对应的子项
                                            new String[] {"eatAdapterText1"},
                                            //ImageItem的XML文件里面的一个ImageView,3个TextView ID
                                            new int[] {R.id.textView9}
                                    );
                                    listAll.setAdapter(listItemAdapter);
                                    listAll.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                                    //以下為監聽list備案下去會跳往另一個active的函式
                                    listAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        ////parent发生点击动作的AdapterView。view在AdapterView中被点击的视图(它是由adapter提供的一个视图)。position视图在adapter中的位置。id被点击元素的行id。
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                            AbsListView list = (AbsListView)parent;
                                            int idx = list.getCheckedItemPosition();
                                            Struct checked = (Struct)parent.getAdapter().getItem(idx);
                                        }
                                    });
                                } catch(JSONException e) {
                                    Log.d("TAG", "json導入超級大失敗"+e.toString());
                                }
                                Log.d("TAG", "成功導入");
                                //生成适配器的Item和动态数组对应的元素

                            } catch (Exception e) {
                                Log.d("TAG", e.toString());
                                Log.e("log_tag", e.toString());
                            }
                        }catch (Exception e) {
                            Log.d("TAG","連線失敗~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            Toast.makeText(context, "連線失敗!", Toast.LENGTH_SHORT).show();
                        }
                    }});
                try {
                    URL url=new URL("http://192.168.0.101/conn.php");//建立網址
                    myAsyncTask.execute(url);//輸入網址到類別裡
                }
                catch (Exception e){
                    Log.d("TAG","連線url失敗~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

            }
        });


    }
}
