package com.grimreaper.sqlitepracticeapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.grimreaper.sqlitepracticeapp.dbmsPkg.DBMS;

public class LoginActivity extends AppCompatActivity {

    EditText edtTxtUserName,edtTxtPass;
    String UserName,Pass;
    Button btnLogin;
    DBMS dbms;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbms = new DBMS(LoginActivity.this);
        edtTxtUserName = (EditText) findViewById(R.id.edt_txt_login_username);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_login_pass);

        btnLogin = (Button) findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserName = edtTxtUserName.getText().toString();
                Pass = edtTxtPass.getText().toString();

                if(UserName.isEmpty()||Pass.isEmpty()){
                    edtTxtUserName.setError("Please fill");
                    edtTxtPass.setError("Please FIll");

                }else{
//                    check the user is registere or not!!!!
                    db = dbms.getReadableDatabase();
                    Cursor c = dbms.checkUserLogedIn(db,UserName,Pass);
                    if(c.getCount()==1){
                        Toast.makeText(LoginActivity.this, "User h registerd", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "User is not there", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void takeUserToRegisterPage(View view){

        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
}
