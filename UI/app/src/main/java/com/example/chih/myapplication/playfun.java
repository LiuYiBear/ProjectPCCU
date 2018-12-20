package com.example.chih.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class playfun extends AppCompatActivity {
    TextView test1;
    org.json.JSONObject JSONObject=new JSONObject();
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.playfun);
        Button backig=(Button)findViewById(R.id.bt14);
        backig.setBackgroundResource(R.drawable.mainplay);
        backig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.setClass(playfun.this,MainActivity.class);
                startActivity(intent);
            }

        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        //--------------------
        // 儲存目前執行環境
        //--------------------
        context = this;
        playfun_listview myAsyncTask=new playfun_listview(context, new playfun_listview.TaskListener() {
            @Override
            public void onFinished(String result) {
                try{
                    if (result == null) {
                        Log.d("TAG","無資料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                        return;
                    }
//                     將由主機取回的字串轉為JSONArray

                    String tmp = result;//導入網頁字串放到tmp裡
                    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();//生成动态数组，加入数据
                    ListView listAll=(ListView)findViewById(R.id.playfunlist);//绑定Layout里面的ListView
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
                                String whatfun = jsonObject.getString("whatfun");
                                String playfun_name = jsonObject.getString("playfun_name");
                                String playfun_phone = jsonObject.getString("playfun_phone");
                                String playfun_address = jsonObject.getString("playfun_address");
                                Log.d("TAG", "whatfun:"+whatfun+"  playfun_name:" +playfun_name);
                                String ktv="ktv";
                                if(ktv.equals(whatfun)){
                                }
                                item.put("playfunAdapterImage",String.valueOf(R.drawable.red));//图像资源的ID//此為替代上面
                                item.put("playfunAdapterText1", playfun_name);
                                item.put("playfunAdapterText2", playfun_phone);
                                item.put("playfunAdapterText3", playfun_address);
                                map.add(item);
                            }
                            //以下為適配器導入
                            SimpleAdapter listItemAdapter = new SimpleAdapter(context,map,//数据源
                                    R.layout.playfun_allview,//ListItem的XML实现
                                    //动态数组与ImageItem对应的子项
                                    new String[] {"playfunAdapterImage","playfunAdapterText1", "playfunAdapterText2","playfunAdapterText3"},
                                    //ImageItem的XML文件里面的一个ImageView,3个TextView ID
                                    new int[] {R.id.playfunAdapterImage,R.id.playfunAdapterText1,R.id.playfunAdapterText2,R.id.playfunAdapterText3}
                            );
                            listAll.setAdapter(listItemAdapter);

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
        Button buttonKTV=(Button)findViewById(R.id.buttonKtvPlayFun);
        Button buttonroomEscape=(Button)findViewById(R.id.buttobgPlayFun);
        Button buttonBOARDGAME=(Button)findViewById(R.id.buttonRPlayFun);
        Button buttonELSE=(Button)findViewById(R.id.buttonELSE);
        buttonKTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playfun_listview myAsyncTask=new playfun_listview(context, new playfun_listview.TaskListener() {
                    @Override
                    public void onFinished(String result) {
                        Log.d("TAG", "ktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktvktv");

                        try{
                            if (result == null) {
                                Log.d("TAG","無資料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                                return;
                            }
//                     將由主機取回的字串轉為JSONArray
                            String tmp = result;//導入網頁字串放到tmp裡
                            ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();//生成动态数组，加入数据
                            ListView listAll=(ListView)findViewById(R.id.playfunlist);//绑定Layout里面的ListView
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
                                        String whatfun = jsonObject.getString("whatfun");
                                        String playfun_name = jsonObject.getString("playfun_name");
                                        String playfun_phone = jsonObject.getString("playfun_phone");
                                        String playfun_address = jsonObject.getString("playfun_address");
                                        String ktv="ktv";
                                        if(ktv.equals(whatfun)){
                                            item.put("playfunAdapterImage",String.valueOf(R.drawable.red));//图像资源的ID//此為替代上面
                                            item.put("playfunAdapterText1", playfun_name);
                                            item.put("playfunAdapterText2", playfun_phone);
                                            item.put("playfunAdapterText3", playfun_address);
                                            map.add(item);
                                        }

                                    }
                                    //以下為適配器導入
                                    SimpleAdapter listItemAdapter = new SimpleAdapter(context,map,//数据源
                                            R.layout.playfun_allview,//ListItem的XML实现
                                            //动态数组与ImageItem对应的子项
                                            new String[] {"playfunAdapterImage","playfunAdapterText1", "playfunAdapterText2","playfunAdapterText3"},
                                            //ImageItem的XML文件里面的一个ImageView,3个TextView ID
                                            new int[] {R.id.playfunAdapterImage,R.id.playfunAdapterText1,R.id.playfunAdapterText2,R.id.playfunAdapterText3}
                                    );
                                    listAll.setAdapter(listItemAdapter);

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
                    URL url=new URL("http://192.168.0.101/playfundata.php");//建立網址
                    myAsyncTask.execute(url);//輸入網址到類別裡
                }
                catch (Exception e){
                    Log.d("TAG","連線url失敗~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    test1.setText(e.toString());//輸出錯誤原因
                }
            }
        });
        buttonroomEscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playfun_listview myAsyncTask=new playfun_listview(context, new playfun_listview.TaskListener() {
                    @Override
                    public void onFinished(String result) {
                        try{
                            if (result == null) {
                                Log.d("TAG","無資料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                                return;
                            }
//                     將由主機取回的字串轉為JSONArray
                            String tmp = result;//導入網頁字串放到tmp裡
                            ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();//生成动态数组，加入数据
                            ListView listAll=(ListView)findViewById(R.id.playfunlist);//绑定Layout里面的ListView
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
                                        String whatfun = jsonObject.getString("whatfun");
                                        String playfun_name = jsonObject.getString("playfun_name");
                                        String playfun_phone = jsonObject.getString("playfun_phone");
                                        String playfun_address = jsonObject.getString("playfun_address");
                                        String roomEscape="roomEscape";
                                        if(roomEscape.equals(whatfun)){
                                            item.put("playfunAdapterImage",String.valueOf(R.drawable.red));//图像资源的ID//此為替代上面
                                            item.put("playfunAdapterText1", playfun_name);
                                            item.put("playfunAdapterText2", playfun_phone);
                                            item.put("playfunAdapterText3", playfun_address);
                                            map.add(item);
                                        }

                                    }
                                    //以下為適配器導入
                                    SimpleAdapter listItemAdapter = new SimpleAdapter(context,map,//数据源
                                            R.layout.playfun_allview,//ListItem的XML实现
                                            //动态数组与ImageItem对应的子项
                                            new String[] {"playfunAdapterImage","playfunAdapterText1", "playfunAdapterText2","playfunAdapterText3"},
                                            //ImageItem的XML文件里面的一个ImageView,3个TextView ID
                                            new int[] {R.id.playfunAdapterImage,R.id.playfunAdapterText1,R.id.playfunAdapterText2,R.id.playfunAdapterText3}
                                    );
                                    listAll.setAdapter(listItemAdapter);

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
                    URL url=new URL("http://192.168.0.101/playfundata.php");//建立網址
                    myAsyncTask.execute(url);//輸入網址到類別裡
                }
                catch (Exception e){
                    Log.d("TAG","連線url失敗~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    test1.setText(e.toString());//輸出錯誤原因
                }
            }
        });

        buttonBOARDGAME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playfun_listview myAsyncTask=new playfun_listview(context, new playfun_listview.TaskListener() {
                    @Override
                    public void onFinished(String result) {
                        try{
                            if (result == null) {
                                Log.d("TAG","無資料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                                return;
                            }
//                     將由主機取回的字串轉為JSONArray
                            String tmp = result;//導入網頁字串放到tmp裡
                            ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();//生成动态数组，加入数据
                            ListView listAll=(ListView)findViewById(R.id.playfunlist);//绑定Layout里面的ListView
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
                                        String whatfun = jsonObject.getString("whatfun");
                                        String playfun_name = jsonObject.getString("playfun_name");
                                        String playfun_phone = jsonObject.getString("playfun_phone");
                                        String playfun_address = jsonObject.getString("playfun_address");
                                        String boardgame="boardgame";
                                        if(boardgame.equals(whatfun)){
                                            item.put("playfunAdapterImage",String.valueOf(R.drawable.red));//图像资源的ID//此為替代上面
                                            item.put("playfunAdapterText1", playfun_name);
                                            item.put("playfunAdapterText2", playfun_phone);
                                            item.put("playfunAdapterText3", playfun_address);
                                            map.add(item);
                                        }

                                    }
                                    //以下為適配器導入
                                    SimpleAdapter listItemAdapter = new SimpleAdapter(context,map,//数据源
                                            R.layout.playfun_allview,//ListItem的XML实现
                                            //动态数组与ImageItem对应的子项
                                            new String[] {"playfunAdapterImage","playfunAdapterText1", "playfunAdapterText2","playfunAdapterText3"},
                                            //ImageItem的XML文件里面的一个ImageView,3个TextView ID
                                            new int[] {R.id.playfunAdapterImage,R.id.playfunAdapterText1,R.id.playfunAdapterText2,R.id.playfunAdapterText3}
                                    );
                                    listAll.setAdapter(listItemAdapter);

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
                    URL url=new URL("http://192.168.0.101/playfundata.php");//建立網址
                    myAsyncTask.execute(url);//輸入網址到類別裡
                }
                catch (Exception e){
                    Log.d("TAG","連線url失敗~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    test1.setText(e.toString());//輸出錯誤原因
                }
            }
        });

        buttonELSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playfun_listview myAsyncTask=new playfun_listview(context, new playfun_listview.TaskListener() {
                    @Override
                    public void onFinished(String result) {
                        try{
                            if (result == null) {
                                Log.d("TAG","無資料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                Toast.makeText(context, "無資料!", Toast.LENGTH_SHORT).show();
                                return;
                            }
//                     將由主機取回的字串轉為JSONArray
                            String tmp = result;//導入網頁字串放到tmp裡
                            ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();//生成动态数组，加入数据
                            ListView listAll=(ListView)findViewById(R.id.playfunlist);//绑定Layout里面的ListView
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
                                        String whatfun = jsonObject.getString("whatfun");
                                        String playfun_name = jsonObject.getString("playfun_name");
                                        String playfun_phone = jsonObject.getString("playfun_phone");
                                        String playfun_address = jsonObject.getString("playfun_address");
                                        String elsegame="elsegame";
                                        if(elsegame.equals(whatfun)){
                                            item.put("playfunAdapterImage",String.valueOf(R.drawable.red));//图像资源的ID//此為替代上面
                                            item.put("playfunAdapterText1", playfun_name);
                                            item.put("playfunAdapterText2", playfun_phone);
                                            item.put("playfunAdapterText3", playfun_address);
                                            map.add(item);
                                        }

                                    }
                                    //以下為適配器導入
                                    SimpleAdapter listItemAdapter = new SimpleAdapter(context,map,//数据源
                                            R.layout.playfun_allview,//ListItem的XML实现
                                            //动态数组与ImageItem对应的子项
                                            new String[] {"playfunAdapterImage","playfunAdapterText1", "playfunAdapterText2","playfunAdapterText3"},
                                            //ImageItem的XML文件里面的一个ImageView,3个TextView ID
                                            new int[] {R.id.playfunAdapterImage,R.id.playfunAdapterText1,R.id.playfunAdapterText2,R.id.playfunAdapterText3}
                                    );
                                    listAll.setAdapter(listItemAdapter);

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
                    URL url=new URL("http://192.168.0.101/playfundata.php");//建立網址
                    myAsyncTask.execute(url);//輸入網址到類別裡
                }
                catch (Exception e){
                    Log.d("TAG","連線url失敗~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    test1.setText(e.toString());//輸出錯誤原因
                }
            }
        });
        try {
            URL url=new URL("http://192.168.0.101/playfundata.php");//建立網址
            myAsyncTask.execute(url);//輸入網址到類別裡
        }
        catch (Exception e){
            Log.d("TAG","連線url失敗~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            test1.setText(e.toString());//輸出錯誤原因
        }
    }
}
