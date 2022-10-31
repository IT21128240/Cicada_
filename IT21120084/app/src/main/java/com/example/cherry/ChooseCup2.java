package com.example.cherry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChooseCup2 extends AppCompatActivity {

    Button c1,c2,c3,c4,c5,c6, cust;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cup2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        c1 = findViewById(R.id.cup1);
        c2 = findViewById(R.id.cup2);
        c3 = findViewById(R.id.cup3);
        c4 = findViewById(R.id.cup4);
        c5 = findViewById(R.id.cup5);
        c6 = findViewById(R.id.cup6);
        cust = findViewById(R.id.customize);

        Button button4;
        button4=(Button) findViewById(R.id.customize);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper d1 = new DBhelper(ChooseCup2.this);
                int volume = 50;


                d1.insertVolume(volume);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper d1 = new DBhelper(ChooseCup2.this);
                int volume = 100;


                d1.insertVolume1(volume);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper d1 = new DBhelper(ChooseCup2.this);
                int volume = 200;


                d1.insertVolume1(volume);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper d1 = new DBhelper(ChooseCup2.this);
                int volume = 500;


                d1.insertVolume1(volume);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper d1 = new DBhelper(ChooseCup2.this);
                int volume = 1000;


                d1.insertVolume1(volume);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper d1 = new DBhelper(ChooseCup2.this);
                int volume = 1500;


                d1.insertVolume1(volume);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChooseCup2.this,Customize2.class);
                startActivity(intent);


            }
        });


    }
}