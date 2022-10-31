package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First extends AppCompatActivity {

    Button btnNutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        getSupportActionBar().setTitle("Blue Blood");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        btnNutrition = findViewById(R.id.button6);

        btnNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(First.this,CalForm.class);
                startActivity(intent);

            }
        });
    }
}