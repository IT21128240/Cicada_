package com.example.testapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etMeal, etFood, etQuantity, etCalories;
    Button btnAdd, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setTitle("Blue Blood");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        etMeal = findViewById(R.id.etMeal);
        etFood = findViewById(R.id.etFood);
        etQuantity = findViewById(R.id.etQuantity);
        etCalories = findViewById(R.id.etCalories);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(AddActivity.this);
                dbHelper.addMeal(etMeal.getText().toString().trim(),
                        etFood.getText().toString().trim(),
                        etQuantity.getText().toString().trim(),
                        Integer.valueOf(etCalories.getText().toString().trim()));
            }
        });
    }

    public void clickView(View v){
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
    }
}