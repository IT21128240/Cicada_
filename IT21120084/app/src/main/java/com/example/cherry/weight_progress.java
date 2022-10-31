package com.example.cherry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class weight_progress extends AppCompatActivity {
    public Button button8;
    public Button cal, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_progress);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

//        button8=(Button) findViewById(R.id.button4);
        cal = findViewById(R.id.glass);
        profile = findViewById(R.id.select);

//        button8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(weight_progress.this,Age.class);
//                startActivity(intent);
//
//            }
//        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create1();
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });

    }

    public void create(){
        Intent intent = new Intent(weight_progress.this, leftdisplay.class);
        startActivity(intent);
    }

    public void create1(){
        Intent intent = new Intent(weight_progress.this, Age.class);
        startActivity(intent);
    }
}