package com.example.grimreaper.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
ListView lstVuFlowers;
    String[] flowerNamesArray = {"Lilly","Blossom","cherry","Rose","THrone","Lilly","Blossom","cherry","Rose","THrone","KINKY","JASMINE","SunFLOWER",};
    ArrayAdapter flowersArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lstVuFlowers = (ListView) findViewById(R.id.lst_vu_flowers);
        flowersArrayAdapter = new ArrayAdapter(SecondActivity.this,R.layout.custom_design_file_listvu,flowerNamesArray);
        lstVuFlowers.setAdapter(flowersArrayAdapter);

//        listView ka click listner

        lstVuFlowers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String incomingClickedString = ((TextView)view).getText().toString();
                Toast.makeText(SecondActivity.this, incomingClickedString, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
