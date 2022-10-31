package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    //creating objects
    FloatingActionButton fab , fab1 , fab2;
    Animation fabOpen  , fabClose , rotateForward , rotateBackward;

    boolean isOpen = false;
    String[] urls;

    Button hmBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //setting action bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionColor)));

        //creating objects and assign it to frontend layout
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Exercise types data for home page
        ExerciseData[] myExerciseData = new ExerciseData[]{
                new ExerciseData("Endurance Exercise","A Endurance exercise keeps your heart, lungs and circulatory system healthy and improves your overall fitness.",R.drawable.ex1_img),
                new ExerciseData("Strength Exercise","Strength exercise helping you to improve your strength, keeping your bones healthy and blood pressure healthy.",R.drawable.exer2),
                new ExerciseData("Balance Exercise","Some Balance exercises can be intense, These kinds of exercises can improve stability and help prevent falls.",R.drawable.exer3),
                new ExerciseData("Flexibility Exercise","Flexibility exercise is a position designed to stretch specific muscles and helps to prevent injuries.",R.drawable.ex4)
        };

        //urls for each type of exercise
        urls = new String[]{"https://www.youtube.com/watch?v=APLK4beh3Fk" ,"https://www.youtube.com/watch?v=-fT2SZ4rTUs" ,"https://www.youtube.com/watch?v=Jv__41ctwp8" ,"https://www.youtube.com/watch?v=jeNwE4VXqgs" };

        //creating object and setAdapter for recyclerView
        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(myExerciseData,MainActivity.this,urls);
        recyclerView.setAdapter(exerciseAdapter);

        //assign values for FloatingActionButton type objects
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab1 = (FloatingActionButton) findViewById(R.id.floatingActionButton1);
        fab2 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);

        //animation
        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this,R.anim.rotate_backward);

        //call functions for each FloatingActionButton type objects
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCreate();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenView();
            }
        });

        //assign variable
        hmBack = findViewById(R.id.hmBack);

        //call function for hmBack button
        hmBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMain();
            }
        });

    }
    //function declarations
    public void OpenMain(){
        Intent intent = new Intent(this,MainHome.class);
        startActivity(intent);
    }

    public void OpenView(){
        Intent intent = new Intent(this,View_Plan.class);
        startActivity(intent);
    }

    public void OpenCreate(){
        Intent intent = new Intent(this,Create_Activity.class);
        startActivity(intent);
    }
    private void animateFab(){
        if(isOpen){
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }else{
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;
        }
    }

    //set page for if user navigate back
    @Override
    public void onBackPressed() {
        gotoHome();
        super.onBackPressed();
    }

    //function declarations
    public void gotoHome(){
        Intent intent = new Intent(this,MainHome.class);
        startActivity(intent);
    }

}
