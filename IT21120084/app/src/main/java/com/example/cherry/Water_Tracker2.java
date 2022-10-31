package com.example.cherry;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Water_Tracker2 extends AppCompatActivity {

    Button plus, undo, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_tracker2);


        TextView goal;
        Button button2;
        Button button3;
        button2=(Button) findViewById(R.id.glass);
        button3=(Button) findViewById(R.id.select);
        plus = findViewById(R.id.plus);
        undo = findViewById(R.id.undo);
        del = findViewById(R.id.del);

        goal =findViewById(R.id.Goal);

        DBhelper db1 = new DBhelper(Water_Tracker2.this);

        Cursor c1 = db1.readData() ;

        if(c1.getCount() == 0){
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }
        else{
            while(c1.moveToNext()){
                goal.setText(c1.getString(1));
            }
        }

    plus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int value = 50;
            int total = Integer.parseInt(goal.getText().toString().trim());

            int final1 = total - value;
            String g1 = final1 + "";
            goal.setText(g1);

        }



    });


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Water_Tracker2.this,ChooseCup2.class);
                startActivity(intent);


            }
        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Water_Tracker2.this,Setgoal2.class);
                startActivity(intent);


            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = 50;
                int total = Integer.parseInt(goal.getText().toString().trim());

                int final1 = total + value;
                String g1 = final1 + "";
                goal.setText(g1);

            }


    });

    del.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s1 = "0";

            goal.setText(s1);
        }
    });
}}