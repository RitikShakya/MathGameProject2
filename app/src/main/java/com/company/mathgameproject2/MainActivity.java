package com.company.mathgameproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addbtn1 , subbtn1, multibtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbtn1 = findViewById(R.id.addbtn);
        subbtn1 = findViewById(R.id.subbtn);
        multibtn1 = findViewById(R.id.multibtn);


        addbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,game.class);
                startActivity(intent);
                finish();
            }
        });
    }
}