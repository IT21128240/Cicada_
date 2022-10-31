package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalDisplay extends AppCompatActivity {

    Button btnCalc, btnBreakfast, btnLunch, btnDinner;
    EditText etAge, etHeight, etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_display);

        getSupportActionBar().setTitle("Blue Blood");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        Intent i = getIntent();

        /*
        etAge=findViewById(R.id.etAge);
        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);

        etAge.setText(i.getStringExtra("Age"));
        etHeight.setText(i.getStringExtra("Height"));
        etWeight.setText(i.getStringExtra("Weight"));

         */

    }

    public void myMeals(View view){
        Intent i = new Intent(CalDisplay.this, MainActivity.class);
        startActivity(i);
    }

    /*
    public void clickCalculate(View view){

        int age = Integer.parseInt(etAge.getText().toString());
                int height = Integer.parseInt(etHeight.getText().toString());
                int weight = Integer.parseInt(etWeight.getText().toString());

                double bmr=0.0f, amr=0.0f;

                if(view.getId() == R.id.rbMale){
                    bmr = 10*weight+6.25*height+5*age+5;

                    if(view.getId() == R.id.rbWeightGain)
                        amr = bmr+500;
                    else
                        amr = bmr-500;
                }

                if(view.getId() == R.id.rbFemale){
                    bmr = 10*weight+6.25*height+5*age-161;

                    if(view.getId() == R.id.rbWeightGain)
                        amr = bmr+500;
                    else
                        amr = bmr-500;
                }

                TextView tv = findViewById(R.id.tvCalories);
                tv.setText("Calories: " + amr);

    }

     */
}