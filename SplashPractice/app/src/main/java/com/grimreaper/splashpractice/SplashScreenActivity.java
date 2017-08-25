package com.grimreaper.splashpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread splashThread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(8000);
                    Intent goToMainPageIntent = new Intent(SplashScreenActivity.this,HomePageActivity.class);
                    startActivity(goToMainPageIntent);
                    finish();
                }catch (Exception e){

                }
            }
        };

//        start the thread splashThread
        splashThread.start();


    }
}
