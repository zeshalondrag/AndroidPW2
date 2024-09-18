package com.example.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.frame_animation);
        frameAnimation = (AnimationDrawable) imageView.getBackground();

        Button startButton = findViewById(R.id.btnStart);
        Button pauseButton = findViewById(R.id.btnPause);
        Button backButton = findViewById(R.id.btnBack);

        Animation buttonSlideIn = AnimationUtils.loadAnimation(this, R.anim.button_slide_in);

        startButton.startAnimation(buttonSlideIn);
        pauseButton.startAnimation(buttonSlideIn);
        backButton.startAnimation(buttonSlideIn);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frameAnimation != null) {
                    frameAnimation.start();
                }
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frameAnimation != null) {
                    frameAnimation.stop();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}