package com.revauniversity.revaite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Starting extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;

    Animation top_anim, bottom_anim;
    TextView reva, university;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_starting);

        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        TextView reva = (TextView) findViewById(R.id.Reva);
        TextView university = (TextView) findViewById(R.id.university);
        ImageView logo = (ImageView) findViewById(R.id.Logo);

        logo.setAnimation(top_anim);
        reva.setAnimation(bottom_anim);
        university.setAnimation(bottom_anim);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        },SPLASH_SCREEN);
    }
}