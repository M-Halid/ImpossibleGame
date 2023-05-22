package com.ewig.impossiblegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Runnable runnable;
    Handler handler;
    TextView score;
    ImageView jess;
    ImageView ziel;
    ConstraintLayout hauptLayout;
    int random1;
    int random2;
    int random3;
    int time=60;
    String userName;
    Button restart;
    Intent intent;
    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent=getIntent();
        jess = findViewById(R.id.jess);
        ziel = findViewById(R.id.ziel);
        hauptLayout = findViewById(R.id.hauptLayout);
        score = findViewById(R.id.score);
        restart = findViewById(R.id.restart);
        ziel.setVisibility(View.INVISIBLE);
        jess.setVisibility(View.INVISIBLE);
        restart.setVisibility(View.INVISIBLE);

        hauptLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                //score.setText("X: " + (int) x + "Y: " + (int) y);

                ziel.setVisibility(View.VISIBLE);

                ziel.setY(y - 140);
                ziel.setX(x - 130);
                return true;
            }
        });


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (time>0){
                random1 = 50+(int) (Math.random() * ((500) + 1));
                random2 = -50 + (int) (Math.random() * ((800) + 1));
                score.setText("Time Left: " + time);
                jess.setVisibility(View.VISIBLE);
                jess.setY(random1 * 3);
                jess.setX(random2);
                time--;

                handler.postDelayed(runnable, 300);
            }else{
                    handler.removeCallbacks(runnable);
                    jess.setImageResource(R.drawable.jailed);
                    score.setText("Your Score is :"+0);
                    jess.setClickable(false);
                }
            }
        };
        handler.post(runnable);}

    public void clicked(View view) {
        handler.removeCallbacks(runnable);
        jess.setImageResource(R.drawable.jailed);
        if (userName==""||userName==" "||userName==null) {
            userName="No Name";
        }
           else{userName= intent.getStringExtra("name");}
        score.setText(userName+" Your Score is: \n"+time);
        restart.setVisibility(View.VISIBLE);}
    public void restart(View view) {
        finish();
    }




}