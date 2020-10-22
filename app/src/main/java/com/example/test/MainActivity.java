package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Math.max;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    TextView tv;
    TextView tv2;
   private int sum1,sum2;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        tv = (TextView) findViewById(R.id.score);
        tv2 = (TextView) findViewById(R.id.instruct);
        tv2.setText("Guess The bigger number and score 5 points to win");

        tv.setText("Score:"+score);

        getRandom();

        btn1.setText(Integer.toString(sum1));
        btn2.setText(Integer.toString(sum2));

        btn1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                btn1operation();
            }
        });

        btn2.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                btn2operation();
            }
        });
    }
    public void btn2operation(){
        if (sum2 > sum1) {
            score = score + 1;
            tv.setText("Score:" + score);
        }  else {
            score--;
            tv.setText("Score:" + score);
        }
        getRandom();
    }

    public void btn1operation(){
        if (sum1 > sum2) {
            score++;
            tv.setText("Score:" + score);
        } else {
            score--;
            tv.setText("Score:" + score);
        }
        getRandom();

    }
    public void getRandom(){
        if(score==5){
            score = 0;
            tv.setText("Score:" + score);
            Toast.makeText(this,"You Won!", Toast.LENGTH_SHORT).show();
        }
        Random rand = new Random();
         sum1 = rand.nextInt(1000);
         sum2 = rand.nextInt(1000);
        btn1.setText(Integer.toString(sum1));
        btn2.setText(Integer.toString(sum2));
    }
}