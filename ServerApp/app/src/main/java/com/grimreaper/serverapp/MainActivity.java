package com.grimreaper.serverapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtName, edtTxtEmail, edtTxtPass, edtTxtAddress;
    String name, pEmail, pass, address;
    Button btnRegister,btnGetAllUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtName = (EditText) findViewById(R.id.edt_txt_name);
        edtTxtEmail = (EditText) findViewById(R.id.edt_txt_email);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_pass);
        edtTxtAddress = (EditText) findViewById(R.id.edt_txt_address);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnGetAllUsers = (Button) findViewById(R.id.btn_get_all_users);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                /taking all the entered values from the user
                name = edtTxtName.getText().toString();
                pEmail = edtTxtEmail.getText().toString();
                pass = edtTxtPass.getText().toString();
                address = edtTxtAddress.getText().toString();

                if (name.isEmpty() || pEmail.isEmpty() || pass.isEmpty() || address.isEmpty()) {
                    edtTxtName.setError("Form Not Filled");
                    edtTxtEmail.setError("Form Not Filled");
                    edtTxtPass.setError("Form Not Filled");
                    edtTxtAddress.setError("Form Not Filled");
                } else {
//                    here we will use the DBMS features
                    InsertNewUser(name,pEmail,pass,address);
                }


            }
        });

        btnGetAllUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


//    Insert New User Method
public void InsertNewUser(final String Name, final String pEmail, final String Pass, final String Address){

    //        StringRequest mStringRequest = new StringRequest(Request.Method.POST,);
    StringRequest mStringRequest = new StringRequest(1,getApplicationContext().getResources().getString(R.string.InsertNewUserUrl) , new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(MainActivity.this, "Server side error", Toast.LENGTH_SHORT).show();
        }
    }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("PersonName",Name);
            params.put("PersonEmail",pEmail);
            params.put("PersonPass",Pass);
            params.put("PersonAddress",Address);
            return params;
        }
    };

    RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);
    mRequestQueue.add(mStringRequest);
}



    public void BringMeTheServerResponse(){

//        StringRequest mStringRequest = new StringRequest(Request.Method.POST,);
        StringRequest mStringRequest = new StringRequest(1,getApplicationContext().getResources().getString(R.string.basic_connection_url) , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Server side error", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mRequestQueue.add(mStringRequest);

    }
}
