package com.abanoubhanna.cheatsheets;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent go = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(go);
                SplashActivity.this.finish();
            }
        }, 3000);
    }
}
