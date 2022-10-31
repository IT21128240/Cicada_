package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainHome extends AppCompatActivity {

    //creating  objects
    Button exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        //setting action bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionColor)));

        //assign object with front end layout
        exercise = findViewById(R.id.button5);

        //call functions for exercise button
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFunc();
            }
        });



    }

    //declare functions
    public void goToFunc(){
        Intent intent = new Intent(MainHome.this,MainActivity.class);
        startActivity(intent);
    }
}