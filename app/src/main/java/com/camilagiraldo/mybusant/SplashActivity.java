package com.camilagiraldo.mybusant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //// Prefenencias
        SharedPreferences prefs = getSharedPreferences("Mis Preferencias", MODE_PRIVATE);
        final int optlog = prefs.getInt("optLog",0);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(SplashActivity.this,LogginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,3000);
    }
}
