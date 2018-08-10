package com.example.chih.myapplication;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import  java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class eatStoreDataConnect extends AppCompatActivity{

    TextView displayResult;


//    @Override
    protected void onCreate(Bundle saveInstanceState){

    }

    public static void main(String[] args){

        try {
            URL url=new URL("http://localhost/conn.php");
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(1500);
            connection.connect();//連結

            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder=new StringBuilder();

            String line=null;
            while (((line=reader.readLine())!=null)){
                stringBuilder.append(line+"\n");
            }
            String webpage=stringBuilder.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
