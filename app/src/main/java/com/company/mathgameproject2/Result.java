package com.company.mathgameproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView score;

    Button exitbtn, playagainbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        score = findViewById(R.id.resultscore);

        exitbtn = findViewById(R.id.exitbtn);
        playagainbtn = findViewById(R.id.playagain);

        Intent intent = getIntent();
        int scoreresult = intent.getIntExtra("scoreresult",0);

        score.setText("Score "+scoreresult);


        playagainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}