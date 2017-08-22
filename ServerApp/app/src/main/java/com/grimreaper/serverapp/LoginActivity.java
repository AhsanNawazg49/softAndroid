package com.grimreaper.serverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    Button btnLogin;
    EditText edtTxtEmail,edtTxtPassword;
    String incomingEmail,incomingPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtTxtEmail = (EditText) findViewById(R.id.edt_txt_login_email);
        edtTxtPassword = (EditText) findViewById(R.id.edt_txt_login_pass);
        btnLogin  = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomingEmail =      edtTxtEmail.getText().toString();
                incomingPassword  =      edtTxtPassword.getText().toString();
                if(incomingEmail.isEmpty()|| incomingPassword.isEmpty()){
                    edtTxtEmail.setError("fill it");
                    edtTxtPassword.setError("fill it");
                }else{

                    StringRequest mStringRequest = new StringRequest(1, getApplicationContext().getResources().getString(R.string.login_the_user), new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this, "Server error", Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("userEmail",incomingEmail);
                            params.put("userPassword",incomingPassword);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                    requestQueue.add(mStringRequest);
                }
            }
        });

    }
}
