package com.example.chih.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import  java.net.URL;



public class eatStoreDataConnect extends AsyncTask<URL, Void, String>{
//讚實不需要這個class可以摻除

    @Override
    protected String doInBackground(URL... urls) {
        //新增
        BufferedReader reader=null;
        StringBuilder StringBuilder;

        try {
            HttpURLConnection connection=(HttpURLConnection)urls[0].openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(1500);
            connection.connect();//連結
            reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder=new StringBuilder();
            String line=null;
            while (((line=reader.readLine())!=null)){
                StringBuilder.append(line+"\n");
            }
            return StringBuilder.toString();


        } catch (Exception e) {
            return e.toString();
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
    protected void onPostExecute(String result){
        System.out.println(result);
    }
}
