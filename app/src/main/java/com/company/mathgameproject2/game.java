package com.company.mathgameproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class game extends AppCompatActivity {

    TextView score, life, time;

    TextView question ;
    EditText answer;

    Button ok , next;

    Random random = new Random();
    int useranswer,realanswer;
    int num1, num2,scoreupdate=0,lifeupdate=3;

    CountDownTimer timer;
    public static final long START_TIMER  = 30000;
    boolean is_timerrun;
    long time_left =START_TIMER;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = findViewById(R.id.livescore);
        life = findViewById(R.id.livesleft);
        time = findViewById(R.id.timeleft);

        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);
        ok = findViewById(R.id.submitbtn);
        next = findViewById(R.id.nextbtn);

        gamecontiue();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                useranswer = Integer.valueOf(answer.getText().toString());

                pauseTimer();
                if(realanswer==useranswer){

                    question.setText("congratulation , this was correct");
                    scoreupdate=scoreupdate+10;

                    score.setText(""+scoreupdate);
                   // answer.setText("");
                    //gamecontiue();

                }else{

                    question.setText("Oops The answer is wrong , try again");

                    lifeupdate=lifeupdate-1;
                    life.setText("" +lifeupdate);
                    //answer.setText("");
                    // gamecontiue();


                }


               // gamecontiue();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if(lifeupdate==0){
                    Intent intent = new Intent(game.this,Result.class);
                    intent.putExtra("scoreresult",scoreupdate );
                    startActivity(intent);
                    finish();


                }else{
                    updateTimer();
                    answer.setText("");
                    gamecontiue();

                }



            }
        });

   }

    public void gamecontiue(){

        num1 = random.nextInt(100);
        num2 = random.nextInt(100);

         realanswer = num1+num2;

        question.setText(num1 +"+" +num2);
        //score.setText(""+0);

        Timer();


    }

    public void Timer(){
        timer= new CountDownTimer(time_left,1000) {
            @Override
            public void onTick(long l) {
                time_left=l;
                updateText();


            }

            @Override
            public void onFinish() {
                is_timerrun =false;
                pauseTimer();
                updateTimer();
                updateText();
                lifeupdate = lifeupdate-1;
                question.setText("Sorry time is up");


            }
        }.start();
        is_timerrun=true;
    }



    public void updateText(){
        int second = (int)(time_left/1000)%60;
        String format = String.format(Locale.getDefault(),"%02d",second);
        time.setText(format);
    }

    public void pauseTimer(){
        timer.cancel();
        is_timerrun=false;
        

    }
    public void updateTimer(){
        time_left=START_TIMER;
        updateText();
    }
}