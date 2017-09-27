package com.varnasus.messagingfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LottieAnimationView animation_view3 = (LottieAnimationView) findViewById(R.id.animation_view3);

        animation_view3.setAnimation("checked_done_.json");
        animation_view3.loop(false);

        animation_view3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Check what state animation is in and act accordingly 
                if (!isClicked) {
                    startAnimation(animation_view3);
                    isClicked = true;
                }
                else {
                    animation_view3.reverseAnimation();
                    isClicked = false;
                }

            }
        });
    }

    public void startAnimation(LottieAnimationView view) {
        view.playAnimation();
    }

    public void stopAnimation(LottieAnimationView view) {
        view.cancelAnimation();
    }

    //*** Good idea to use this animation listener to track animation state

//    AnimationListener animListener;
//
//
//    animListener = new Animation.AnimationListener() {
//
//        @Override
//        public void onAnimationStart(Animation animation) {
//            // TODO Auto-generated method stub
//
//        }
//
//        @Override
//        public void onAnimationRepeat(Animation animation) {
//            // TODO Auto-generated method stub
//
//        }
//
//        @Override
//        public void onAnimationEnd(Animation animation) {
//            btn.setVisibility(View.VISIBLE);
//        }
//    };
//animation2.setAnimationListener(animListener);

}
