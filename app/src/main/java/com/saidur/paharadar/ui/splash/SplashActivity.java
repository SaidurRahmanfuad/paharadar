package com.saidur.paharadar.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.saidur.paharadar.R;

public class SplashActivity extends AppCompatActivity {
    private static int Splashtimeout = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        YoYo.with(Techniques.DropOut)
                .duration(7000)
                .playOn(findViewById(R.id.logo));

       /* YoYo.with(Techniques.FadeInUp)
                .duration(5000)
                .playOn(findViewById(R.id.appname));*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,InstructionActivity.class));
                finish();
            }
        },Splashtimeout);
    }
}
