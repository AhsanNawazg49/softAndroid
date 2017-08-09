package com.grimreaper.sqlitepracticeapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.grimreaper.sqlitepracticeapp.dbmsPkg.DBMS;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtName,edtTxtFName,edtTxtPass,edtTxtAddress;
    String  name,fname,pass,address;
    Button btnRegister;

//    our custom Database Manager instance
    DBMS dbms;
//    Helper to close or open the DB
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtName = (EditText) findViewById(R.id.edt_txt_name);
        edtTxtFName = (EditText) findViewById(R.id.edt_txt_fname);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_pass);
        edtTxtAddress = (EditText) findViewById(R.id.edt_txt_address);

        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                /taking all the entered values from the user
                name = edtTxtName.getText().toString();
                fname = edtTxtFName.getText().toString();
                pass = edtTxtPass.getText().toString();
                address = edtTxtAddress.getText().toString();

                if(name.isEmpty()||fname.isEmpty()||pass.isEmpty()||address.isEmpty()){
                    edtTxtName.setError("Form Not Filled");
                    edtTxtFName.setError("Form Not Filled");
                    edtTxtPass.setError("Form Not Filled");
                    edtTxtAddress.setError("Form Not Filled");
                }else{
//                    here we will use the DBMS features
                }


            }
        });
    }
}
