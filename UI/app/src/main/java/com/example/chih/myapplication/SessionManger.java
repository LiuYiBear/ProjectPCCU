package com.example.chih.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;


//管理器
public class SessionManger {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME="LOGIN";
    private static final String LOGIN ="IS_LOGIN";
    public static final String NAME="NAME";
    public static final String EMAIL ="EMAIL";
    public static final String ID="ID"; // p5增加的


    public SessionManger(Context context){
        this.context=context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public  void  createSession(String name,String email,String id){
        editor.putBoolean(LOGIN,true); // 布林編輯值
        editor.putString(NAME,name);  //名字字串編輯值
        editor.putString(EMAIL,email); //信箱字串編輯值
        editor.putString(ID,id); // p5增加的  // ID字串編輯值
        editor.apply();
    }

    public  boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }

    public void checkLogin(){

        if (!this.isLoggin()){
            Intent i= new Intent(context,set_login.class);
            context.startActivity(i);
            ((set_information)context).finish();
        }
    }

    public HashMap<String,String> getUserDetail(){

        HashMap<String,String>user= new HashMap<>();
        user.put(NAME,sharedPreferences.getString(NAME,null)); //  sharedPreferences是Android的一個介面，可在Activity中呼叫getSharedPreferences(String, int)方法得到物件。
        user.put(EMAIL,sharedPreferences.getString(EMAIL,null));
        user.put(ID,sharedPreferences.getString(ID,null)); // p5增加的
        return  user;
    }

    public void logout(){

        editor.clear();
        editor.commit();
        Intent i= new Intent(context,set_login.class);
        context.startActivity(i);
        ((set_information)context).finish();
    }
}
