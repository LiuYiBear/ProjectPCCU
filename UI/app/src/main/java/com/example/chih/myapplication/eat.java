package com.example.chih.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.chih.myapplication.eat_store_data_mylistview;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class eat extends AppCompatActivity {
    TextView test1;
    JSONObject JSONObject=new JSONObject();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eat);
        Button backig=(Button)findViewById(R.id.bt14);
        backig.setBackgroundResource(R.drawable.eat1);
        backig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.setClass(eat.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //以下為添加data連結測試
        Context context=this;
//        eatStoreDataConnectDemo a=new eatStoreDataConnectDemo(context,new eatStoreDataConnectDemo().Tas){};//連結javaeatStoreDataConnect


        Log.d("TAG","onCreateaaaaaaaaaaaaaaa函式~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //end

    }
    // 首次載入App時會執行onResume(), 下次Activity由背景回到前景時也會執行onResume()
    @Override
    protected void onResume() {
        super.onResume();

        //--------------------
        // 儲存目前執行環境
        //--------------------
        context = this;

        // (1)宣告一個處理資料取回後, 處理回傳JSON格式資料的物件.
        eat_store_data_mylistview myAsyncTask=new eat_store_data_mylistview(context, new eat_store_data_mylistview.TaskListener() {
            @Override
            public void onFinished(String result) {
                try{
//
                    if (result == null) {
                        Log.d("TAG","無資料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                        return;
                }
                    // 將由主機取回的字串轉為JSONArray

                    String tmp = result;//導入網頁字串放到tmp裡
                    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();//生成动态数组，加入数据
                    ListView list=(ListView)findViewById(R.id.list2);//绑定Layout里面的ListView
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
                                String store_id = jsonObject.getString("store_id");
                                String store_name = jsonObject.getString("store_name");
                                String store_photo = jsonObject.getString("store_photo");
                                String store_address = jsonObject.getString("store_address");
                                Log.d("TAG", "store_name:"+store_name+ "store_photo:" +store_photo);

//                              item.put("eatAdapterImage", store_id.toString());//图像资源的ID
                                item.put("eatAdapterImage", "aa");//图像资源的ID//此為替代上面
                                item.put("eatAdapterText1", store_name.toString());
                                item.put("eatAdapterText2", store_photo.toString());
                                item.put("eatAdapterText3", store_address.toString());

                                map.add(item);

                            }

                            SimpleAdapter listItemAdapter = new SimpleAdapter(context,map,//数据源
                                    R.layout.eat_store_allview,//ListItem的XML实现
                                    //动态数组与ImageItem对应的子项
                                    new String[] {"eatAdapterImage","eatAdapterText1", "eatAdapterText2","eatAdapterText3"},
                                    //ImageItem的XML文件里面的一个ImageView,3个TextView ID
                                    new int[] {R.id.eatAdapterImage,R.id.eatAdapterText1,R.id.eatAdapterText2,R.id.eatAdapterText3}
                            );
                            list.setAdapter(listItemAdapter);
                            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                ////parent发生点击动作的AdapterView。view在AdapterView中被点击的视图(它是由adapter提供的一个视图)。position视图在adapter中的位置。id被点击元素的行id。
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    Log.d("TAG", "以點item");
                                    Intent intent=new Intent();
                                    intent.setClass(eat.this,eat_store_data.class);
                                    JSONObject jsonObject=new JSONObject();
                                    int newid=(int)id;
                                    try {
                                        jsonObject=array.getJSONObject(newid);
                                        String store_name = jsonObject.getString("store_name");
                                        String store_photo = jsonObject.getString("store_photo");
                                        String store_address = jsonObject.getString("store_address");
                                        String store_menu_path = jsonObject.getString("store_menu_path");
                                        String store_photo_path = jsonObject.getString("store_photo_path");
                                        intent.putExtra("store_name",store_name);//傳出去
                                        intent.putExtra("store_photo",store_photo);
                                        intent.putExtra("store_address",store_address);
                                        intent.putExtra("store_menu_path",store_menu_path);
                                        intent.putExtra("store_photo_path",store_photo_path);

                                        Log.d("TAG", "store_name:"+store_name+"store_photo:"+store_photo+"store_address:"+store_address+"store_menu_path"+store_menu_path+"store_photo_path:"+store_photo_path);


                                    }catch (JSONException e){
                                        Log.d("TAG", "無法拋出問題:"+e.toString());
                                    }


                                    startActivity(intent);

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
            test1.setText(e.toString());//輸出錯誤原因
        }

        }
}










