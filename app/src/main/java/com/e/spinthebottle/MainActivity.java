package com.e.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;
    Random random = new Random();
    boolean spinning;
    int lastDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!spinning)
                {
                    int newDir = random.nextInt(3600);

                    float pivotX = bottle.getWidth()/2;
                    float pivotY = bottle.getHeight()/2;

                    Animation rotate = new RotateAnimation(lastDir,newDir,pivotX,pivotY);
                    rotate.setDuration(3000);
                    rotate.setFillAfter(true);

                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            spinning = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            spinning=false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    lastDir=newDir;
                    bottle.startAnimation(rotate);

                }



            }
        });
    }
}