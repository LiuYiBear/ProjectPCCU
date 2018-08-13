package com.example.chih.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class eat extends AppCompatActivity {
    TextView test1;
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
        test1=(TextView)findViewById(R.id.textView8);
        eatStoreDataConnectDemo a=new eatStoreDataConnectDemo();//連結javaeatStoreDataConnect

        try {
            URL url=new URL("http://192.168.0.101/conn.php");//建立網址
            a.execute(url);//輸入網址到類別裡

        }
        catch (Exception e){
            test1.setText(e.toString());//輸出錯誤原因
        }

    }

    public class eatStoreDataConnectDemo extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            //新增
            BufferedReader reader=null;//取得輸入類別
            StringBuilder StringBuilder;//表示可變動的字元字串

            try {
                HttpURLConnection connection=(HttpURLConnection)urls[0].openConnection();//創建連接類別
                connection.setRequestMethod("GET");//使用get獲取網頁
                connection.setReadTimeout(1500);//當延遲1.5秒就停止抓取網頁
                connection.connect();//連結網頁
                reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));//抓取網頁字串進入reader
                StringBuilder=new StringBuilder();//表示可變動字串
                String line=null;
                while (((line=reader.readLine())!=null)){//把字串每行每行輸入到line
                    StringBuilder.append(line+"\n");//輸入到變動字串中
                }
                return StringBuilder.toString();//輸出字串

            } catch (Exception e) {
                return e.toString();//輸出例外原因
            } finally {
                if(reader!=null)
                    try {
                        reader.close();
                    } catch (IOException ioe){
                        return ioe.toString();
                    }
            }
        }

        @Override
        protected void onPostExecute(String result){//做收尾的類別
            test1.setText(result);
        }
    }


}





