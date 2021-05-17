package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.constraintlayout.widget.ConstraintLayout;

//import android.content.Intent;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
//import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.view.View.*;


public class gameStart extends AppCompatActivity {
    TextView timerTextView;
    TextView sumTextView;
    TextView pointsTextView;
    TextView resultTextView;


    //GridLayout gridLayout;
    ConstraintLayout gameConstraintLayout;


    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgainButton;

    boolean stateOfTimer=true;



    ArrayList<Integer> answer= new ArrayList<>();
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfQuestions=0;

    @SuppressLint("SetTextI18n")





    public void playAgain(final View view) {





        try {

            score = 0;
            numberOfQuestions = 0;
            timerTextView.setText("30s");
            pointsTextView.setText("0/0");
            resultTextView.setText("");
            startTimer();
            playAgainButton.setVisibility(VISIBLE);

            generateQuestion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        private void startTimer(){

            try {
                playAgainButton.setEnabled(false);

                new CountDownTimer(31000, 1000) {


                    @Override
                    public void onTick(long millisUntilFinished) {

                        if(millisUntilFinished<=0) {
                            //each time the timer ticks down we have to update the timer

                            stateOfTimer = false;

                            timerTextView.setText(millisUntilFinished / 1000 + "s");
                        }else{
                            stateOfTimer=true;
                            timerTextView.setText(millisUntilFinished / 1000 + "s");

                        }


                    }

                    @Override
                    public void onFinish() {

                        stateOfTimer=false;


                       playAgainButton.setEnabled(true);
                        playAgainButton.setVisibility(VISIBLE);
                        timerTextView.setText("0s");

                        resultTextView.setText("YOUR SCORE :" + score + "/" + numberOfQuestions);

                    }
                }.start();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }





    @SuppressLint("SetTextI18n")
    public void generateQuestion() {
        try {


            if(stateOfTimer==true) {


                Random rand = new Random();
                int a = rand.nextInt(21);
                int b = rand.nextInt(21);

                //to update the sum text view

                sumTextView.setText(a + "+" + b);

                //several random num location want to be between 0 to 3 button

                locationOfCorrectAnswer = rand.nextInt(4);
                //to remove all option after new question

                answer.clear();
                int incorrectAnswer;
                //loop through each button

                for (int i = 0; i < 4; i++) {

                    if (i == locationOfCorrectAnswer) {
                        answer.add(a + b);

                    } else {
                        //if we are going 0 to 20 for two num then add 41 for a=21 b=21
                        incorrectAnswer = rand.nextInt(41);
                        while (incorrectAnswer == a + b) {
                            incorrectAnswer = rand.nextInt(41);

                        }
                        answer.add(incorrectAnswer);

                    }

                }


                button0.setText(Integer.toString(answer.get(0)));
                button1.setText(Integer.toString(answer.get(1)));
                button2.setText(Integer.toString(answer.get(2)));
                button3.setText(Integer.toString(answer.get(3)));
            }
        }catch (Exception e){
            e.printStackTrace();

        }


        }





    @SuppressLint("SetTextI18n")
    public void chooseAnswer(View view){
        if(stateOfTimer == true) {
            try {
                if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {

                    score++;
                    resultTextView.setText("CORRECT!!!");

                } else {
                    resultTextView.setText("WRONG!");


                }

                //to get new question

                numberOfQuestions++;
                pointsTextView.setText(score + "/" + numberOfQuestions);

                //after asking question
                generateQuestion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            resultTextView.setText("Times Up");
        }


    }

/*
    public void start(View view){

        //startButton.setVisibility( view.INVISIBLE );
        //gameConstraintLayout.setVisibility( ConstraintLayout.VISIBLE );
        playAgain(findViewById( R.id.playAgainButton ));



    }*/









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);





        timerTextView= findViewById( R.id.timerTextView );
        sumTextView= findViewById( R.id.sumTextView );
        pointsTextView= findViewById( R.id.pointsTextView);
        resultTextView= findViewById( R.id.resultTextView );

        button0= findViewById( R.id.button0 );
        button1= findViewById( R.id.button1 );
        button2= findViewById( R.id.button2 );
        button3= findViewById( R.id.button3 );
        playAgainButton=findViewById( R.id.playAgainButton);


        gameConstraintLayout=findViewById( R.id.gameConstraintLayout );


        startTimer();
        generateQuestion();



        //gridLayout=findViewById( R.id.gridLayout );


       //Intent intent=getIntent();
    }
}