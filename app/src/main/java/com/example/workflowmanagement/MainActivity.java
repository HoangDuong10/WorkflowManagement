package com.example.workflowmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation topAnim,botAnim;
    TextView textView;
    ImageView imageView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        textView = (TextView) findViewById(R.id.textView1);
        imageView = (ImageView) findViewById(R.id.imageview1);
        cardView =(CardView) findViewById(R.id.cardview1);
        cardView.setAnimation(topAnim);
        textView.setAnimation(botAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,SplashActivity2.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}