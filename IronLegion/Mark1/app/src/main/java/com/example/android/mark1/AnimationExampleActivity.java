package com.example.android.mark1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationExampleActivity extends AppCompatActivity{

    AnimationClass Animations = new AnimationClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_example);

        final ImageView image = (ImageView)findViewById(R.id.chiefs_logo);

        findViewById(R.id.slide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide(image);
//                Animations.clockwise(image);
            }
        });

        findViewById(R.id.fade).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fade(image);
//                Animations.clockwise(image);
            }
        });

        findViewById(R.id.clockwise).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clockwise(image);
//                Animations.clockwise(image);
            }
        });

        findViewById(R.id.zoom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoom(image);
            }
        });

        findViewById(R.id.blink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blink(image);
            }
        });

        findViewById(R.id.move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move(image);
            }
        });
    }

    public void slide(View view){
        ImageView image = (ImageView)findViewById(R.id.chiefs_logo);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }

    public void clockwise(View view){
        ImageView image = (ImageView)findViewById(R.id.chiefs_logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.clockwise);
        image.startAnimation(animation);
    }

    public void zoom(View view){
        ImageView image = (ImageView)findViewById(R.id.chiefs_logo);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.myanimation);
        image.startAnimation(animation1);
    }

    public void fade(View view){
        ImageView image = (ImageView)findViewById(R.id.chiefs_logo);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view){
        ImageView image = (ImageView)findViewById(R.id.chiefs_logo);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
    }

    public void move(View view){
        ImageView image = (ImageView)findViewById(R.id.chiefs_logo);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }

}
