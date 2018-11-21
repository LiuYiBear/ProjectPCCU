package com.example.chih.myapplication;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import org.apache.http.client.fluent.Content;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class traffic_allbus_data_mylistview extends AsyncTask<URL, Void, String>{
    private ProgressDialog loading;
    private Context context;
    public interface TaskListener {
        // 宣告一個接收回傳結果的程式必須實作的介面
        void onFinished(String result);
    }
    private TaskListener taskListener;
    // 建構元, 傳入(1)context, (2)取回資料後執行的程式
    public traffic_allbus_data_mylistview(Context context,TaskListener taskListener){
        this.context=context;
        this.taskListener = taskListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading = ProgressDialog.show(context, "下載中", "請稍等...", false, false);
    }

    @Override
    protected String doInBackground(URL... urls) {
        Log.d("TAG", "doIn函式~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //以下開始製作POST分類按鈕功能

        //新增
        BufferedReader reader = null;//取得輸入類別
        StringBuilder StringBuilder;//表示可變動的字元字串

        //以下是開始連結網頁並獲取網頁BODY
        try {
            HttpURLConnection connection = (HttpURLConnection) urls[0].openConnection();//創建連接類別
            connection.setRequestMethod("GET");//使用get獲取網頁
            connection.setReadTimeout(1500);//當延遲1.5秒就停止抓取網頁
            connection.connect();//連結網頁
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//抓取網頁字串進入reader
            StringBuilder = new StringBuilder();//表示可變動字串
            String line = null;
            while (((line = reader.readLine()) != null)) {//把字串每行每行輸入到line
                StringBuilder.append(line + "\n");//輸入到變動字串中
            }
            return StringBuilder.toString();//輸出字串

        } catch (Exception e) {
            return e.toString();//輸出例外原因
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException ioe) {
                    return ioe.toString();
                }
        }
    }

    @Override
    protected void onPostExecute(String result) {//做收尾的類別
        super.onPostExecute(result);
        loading.dismiss();
        taskListener.onFinished(result);


    }
    @Override
    protected void onCancelled(String result) {
        super.onCancelled(result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

}
