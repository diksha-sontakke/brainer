package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN=5000;


    Animation topAnimation,bottomAnimation;
    ImageView fish;
    TextView slogan,logo;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        //requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );


        setContentView( R.layout.activity_main );

        //Animation

        topAnimation= AnimationUtils.loadAnimation( this,R.anim.top_anim );
        bottomAnimation= AnimationUtils.loadAnimation( this,R.anim.bottom_anim);

        //assign controls


        fish= findViewById( R.id.imageView );
        logo=findViewById( R.id.logotextView );
        slogan=findViewById( R.id.sloganTextView );


        //to set animation

        fish.setAnimation( topAnimation );
        logo.setAnimation( bottomAnimation );
        slogan.setAnimation( bottomAnimation );





        //calling intent inside delay method

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,startGame.class);
                startActivity(intent);
                finish();
            }
        } ,SPLASH_SCREEN);














































        /*
        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();


        dpHeight=(displayMetrics.heightPixels);
        dpWidth=(displayMetrics.widthPixels);
        dDensity=(displayMetrics.scaledDensity);

        ImageView imageView=(ImageView) findViewById( R.id.imageView );
        ConstraintLayout splashConstraintLayout= (ConstraintLayout) findViewById( R.id.splashContraintLayout );
        TextView logoTextView=(TextView) findViewById( R.id.logotextView );
        TextView  sloganTextView=(TextView) findViewById( R.id.sloganTextView );

        ViewGroup.LayoutParams imageViewParams=(ViewGroup.MarginLayoutParams) imageView.getLayoutParams();

        imageViewParams.height= CalcHeight(703);



        //to get the constraint layout height use this line splashConstraintLayout.getHeight()
        splashConstraintLayout.setPadding( 0,CalcHeight(splashConstraintLayout.getHeight()),0,0 );


        //for textView

        ViewGroup.LayoutParams logoTextViewParams=(ViewGroup.MarginLayoutParams) logoTextView.getLayoutParams();

        logoTextViewParams.height= CalcHeight(186);
        logoTextViewParams.width= CalcWeight(723);



        ViewGroup.LayoutParams sloganTextViewParams=(ViewGroup.MarginLayoutParams) sloganTextView.getLayoutParams();

        sloganTextViewParams.height= CalcHeight(97);
        sloganTextViewParams.width= CalcWeight(795);



    }

    private int CalcWeight(float value) {
        return (int) (dpHeight * (value/designHeight));

    }



    private int CalcHeight(float value) {

        return (int) (dpWidth * (value/designwidth));

    }

         */

    }
}







