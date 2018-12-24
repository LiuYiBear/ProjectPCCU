package com.example.chih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class set_login extends AppCompatActivity {
    private EditText email,password;
    private Button btn_login;
    private TextView link_regist;
    private ProgressBar loading;
    private static String URL_LOGIN = "http://192.168.0.101/android_register_login/login.php"; // 連接登入的php檔案  // "http://127.0.0.1/android_register_login/login.php"




    SessionManger sessionManger;//  p4加入的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtil.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_login);

        sessionManger = new SessionManger(this);//  p4加入的

        loading = findViewById(R.id.loading);
        email = findViewById(R.id.email);
        password= findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        link_regist = findViewById(R.id.link_regist);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()) {  //檢查是否有輸入信箱與密碼
                    Login(mEmail,mPass);
                } else {
                    email.setError("please insert  email");
                    password.setError("please insert password");
                }
            }
        });
        link_regist.setOnClickListener(new View.OnClickListener() {   //這是註冊按鈕的監聽器
            @Override
            public void onClick(View v) {
                startActivity(new Intent(set_login.this,set_registered.class));
            }
        });
    }
    private void Login(final String email, final String password) {  // 登入的所有步驟
        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")){
                                for (int i=0;i < jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String name=object.getString("name").trim();
                                    String email=object.getString("email").trim();
                                    String id=object.getString("id").trim();

                                    sessionManger.createSession(name,email,id);

                                    Intent intent = new Intent(set_login.this,MainActivity.class);
                                    intent.putExtra("name",name);
                                    intent.putExtra("email",email);
                                    startActivity(intent);

                                   /* Toast.makeText(LoginActivity.this,"Success LOGIN \n " +
                                                                 "Your name :"+name+"Your email"+email,
                                                                   Toast.LENGTH_SHORT).show(); */ //第三部分刪除的
                                    loading.setVisibility(View.GONE);
                                }
                            }
                        }catch (JSONException e){
                            loading.setVisibility(View.GONE);
                            btn_login.setVisibility(View.VISIBLE);
                            e.printStackTrace();
                            Toast.makeText(set_login.this, " 登入失敗\n" + e.toString(), Toast.LENGTH_LONG).show();

                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(set_login.this, " 有錯誤\n" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                } )

        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                300, // 300是處理搜尋時間
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
}
