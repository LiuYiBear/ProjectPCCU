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
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        Log.d("TAG", "degrees:"+degrees);
        // do this for each of the numbers
        if (degrees >=  0 && degrees <= 30) {
            text = "The X Burgerd";
        }
        if (degrees >= 31 && degrees <=  60) {
            text = "凱莉餐廳";
        }
        if (degrees >= 61 && degrees <= 90) {
            text = "可米可小西餐坊";
        }
        if (degrees >=  91 && degrees <= 120) {
            text = "大陸麵店";
        }
        if (degrees >= 121 && degrees <=  150) {
            text = "媽媽樂";
        }
        if (degrees >=  151 && degrees <=  180) {
            text = "宵夜快餐";
        }
        if (degrees >= 181 && degrees <=  210) {
            text = "屋頂上";
        }
        if (degrees >= 211 && degrees <= 240) {
            text = "晨華早餐";
        }
        if (degrees >= 241 && degrees <=  270) {
            text = "牛肉拌麵";
        }
        if (degrees >=  271 && degrees <=  300) {
            text = "感恩麵店";
        }
        if (degrees >=  301 && degrees <= 330) {
            text = "阿囉哈";
        }
        if (degrees >=  331 && degrees <=  360) {
            text = "麥當勞";
        }

        return text;
    }

    @Override
    protected void onResume() {
        super.onResume();
        context =this;
        final Button buttonStoreChose=(Button)findViewById(R.id.storeSelect);
        Button GameStoreAdd=(Button)findViewById(R.id.GameStoreAdd);
        GameStoreAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ListView listGameStore=(ListView)findViewById(R.id.listGameStore);
                listGameStore.setVisibility(View.INVISIBLE);
                Button GameStoreAdd=(Button)findViewById(R.id.GameStoreAdd);
                GameStoreAdd.setVisibility(View.INVISIBLE);
            }
        });
        buttonStoreChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listGameStore=(ListView)findViewById(R.id.listGameStore);
                listGameStore.setVisibility(View.VISIBLE);
                Button GameStoreAdd=(Button)findViewById(R.id.GameStoreAdd);
                GameStoreAdd.setVisibility(View.VISIBLE);

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
                            final ListView listAll=(ListView)findViewById(R.id.listGameStore);//绑定Layout里面的ListView
                            tmp = tmp.substring(tmp.indexOf("["), tmp.lastIndexOf("]") + 1);//做字串內容擷取
                            tmp = tmp.substring(0,tmp.length() - 2);
                            tmp=tmp+"]";
                            Log.d("TAG", tmp);
                            try {
                                try {
                                    final JSONArray array = new JSONArray(tmp);
                                    final ArrayList<HashMap<String, String>> map = new ArrayList<>();
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
                                            new int[] {R.id.checkBox}
                                    );
                                    listAll.setAdapter(listItemAdapter);
                                    listAll.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                                    //以下為監聽list備案下去會跳往另一個active的函式
                                    listAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        ////parent发生点击动作的AdapterView。view在AdapterView中被点击的视图(它是由adapter提供的一个视图)。position视图在adapter中的位置。id被点击元素的行id。
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//parent是识别是哪个listview，view是当前listview的item的view的布局，就是可以用这个view，获取里面的控件的id后操作控件，position是当前item在listview中适配器里的位置，id是当前item在listview里的第几行的位置
                                            Log.d("TAG","position:"+position+"id:"+id);
                                            HashMap<String, String> item = map.get(position);
                                            String name = (String) item.get("eatAdapterText1");
                                            Log.d("TAH", "CLICKCLICKCLICKCLICKCLICKCLICKCLICKCLICKCLICKCLICKCLICK: ");

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
