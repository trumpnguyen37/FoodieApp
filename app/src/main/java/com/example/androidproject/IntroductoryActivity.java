package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo, appName, splashImg;
    LottieAnimationView lottieAnimationView;
    FloatingActionButton fab;
    int currentProg=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);
//        fab = findViewById(R.id.fab);

        splashImg.animate().translationY(-3600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2600).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(2600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2600).setDuration(1000).setStartDelay(4000);

        Intent();

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(IntroductoryActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });



    }

    public void Intent(){
        final Timer t = new Timer();
        Intent intent = new Intent(IntroductoryActivity.this, LoginActivity.class);
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                currentProg++;
                if (currentProg==70){
                    t.cancel();
                    startActivity(intent);
                }
            }
        };
        t.schedule(tt,0,70);
    }


}