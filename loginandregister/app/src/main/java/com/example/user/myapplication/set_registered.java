package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class set_registered extends AppCompatActivity {

    private EditText name,email,password,c_password;
    private Button btn_regist;
    private ProgressBar loading;
    private static String URL_REGIST = " http://100.76.25.173/android_register_login/register.php";//" http://127.0.0.1/android_register_login/register.php"  //192.168.1.3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtil.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_registered);

        loading = findViewById(R.id.loading);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password= findViewById(R.id.password);
        c_password = findViewById(R.id.c_password);
        btn_regist = findViewById(R.id.btn_regist);

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();
            }
        });
    }
    private void Regist(){
        loading.setVisibility(View.VISIBLE);
        btn_regist.setVisibility(View.GONE);

        final String name =this.name.getText().toString().trim();
        final String email =this.email.getText().toString().trim();
        final String password =this.password.getText().toString().trim();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");  //註冊成功顯示

                            if (success.equals("1")) {
                                Toast.makeText(set_registered.this, "註冊成功!", Toast.LENGTH_LONG).show(); //註冊成功顯示
                                loading.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(set_registered.this, "註冊失敗\n" + e.toString(), Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);//loading.setVisibility(View.VISIBLE);
                            btn_regist.setVisibility(View.VISIBLE);//btn_regist.setVisibility(View.GONE);
                        }
                    }
                },
                new Response.ErrorListener() {   //沒有連結到資料庫
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(set_registered.this, "有錯誤沒有連結到資料庫\n" + error.toString(), Toast.LENGTH_LONG).show();
                        loading.setVisibility(View.GONE);//loading.setVisibility(View.VISIBLE);
                        btn_regist.setVisibility(View.VISIBLE);//btn_regist.setVisibility(View.GONE);
                    }
                })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("name",name);
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
