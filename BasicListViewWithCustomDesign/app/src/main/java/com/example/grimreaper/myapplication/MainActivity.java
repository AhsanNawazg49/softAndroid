package com.example.grimreaper.myapplication;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Spinner ageSpinner;
    Button btnGoToNextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoToNextPage = (Button) findViewById(R.id.btn_next_page);
        ageSpinner = (Spinner) findViewById(R.id.spnr_age);
//the listner for spinner is!!!  called on ITEMSELECTED LISTNER
        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView spinnetTextView = (TextView) view;
                String spinTextString= spinnetTextView.getText().toString();

//                String spinTextString =((TextView)view).getText().toString();

                Toast.makeText(MainActivity.this, spinTextString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnGoToNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

    }
}
