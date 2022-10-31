package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalForm extends AppCompatActivity {

    Button btnCalculate, rbMale, rbFemale, rbWeightGain, rbWeightLoss;
    EditText etnAge, etnHeight, etnWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_form);

        getSupportActionBar().setTitle("Blue Blood");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        btnCalculate = findViewById(R.id.btnCalculate);
        etnAge = findViewById(R.id.etAge);
        etnHeight = findViewById(R.id.etHeight);
        etnWeight = findViewById(R.id.etWeight);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbWeightGain = findViewById(R.id.rbWeightGain);
        rbWeightLoss = findViewById(R.id.rbWeightLoss);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CalForm.this, CalDisplay.class);

                //load data
                i.putExtra("Age", etnAge.getText().toString());
                i.putExtra("Height", etnHeight.getText().toString());
                i.putExtra("Weight", etnWeight.getText().toString());
                i.putExtra("Male", rbMale.getText().toString());
                i.putExtra("Female", rbFemale.getText().toString());
                i.putExtra("Gain", rbWeightGain.getText().toString());
                i.putExtra("Loss", rbWeightLoss.getText().toString());

                startActivity(i);
            }
        });
    }
}