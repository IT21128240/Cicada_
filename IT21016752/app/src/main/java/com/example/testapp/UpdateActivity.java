package com.example.testapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText etMeal, etFood, etQuantity, etCalories;
    Button btnUpdate, btnDelete;

    String id, meal_title, food_name, quantity, calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getSupportActionBar().setTitle("Blue Blood");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        etMeal = findViewById(R.id.etMeal2);
        etFood = findViewById(R.id.etFood2);
        etQuantity = findViewById(R.id.etQuantity2);
        etCalories = findViewById(R.id.etCalories2);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        getAndSetIntentData();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(UpdateActivity.this);
                meal_title = etMeal.getText().toString().trim();
                food_name = etFood.getText().toString().trim();
                quantity = etQuantity.getText().toString().trim();
                calories = etCalories.getText().toString().trim();
                dbHelper.updateData(id, meal_title, food_name, quantity, calories);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("meal_title") &&
                getIntent().hasExtra("food_name") && getIntent().hasExtra("quantity") &&
                getIntent().hasExtra("calories")){
            //getting data from intent
            id = getIntent().getStringExtra("id");
            meal_title = getIntent().getStringExtra("meal_title");
            food_name = getIntent().getStringExtra("food_name");
            quantity = getIntent().getStringExtra("quantity");
            calories = getIntent().getStringExtra("calories");

            //setting intent data
            etMeal.setText(meal_title);
            etFood.setText(food_name);
            etQuantity.setText(quantity);
            etCalories.setText(calories);

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + meal_title + "?");
        builder.setMessage("Are you sure you want to deleted " + meal_title + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHelper dbHelper = new DBHelper(UpdateActivity.this);
                dbHelper.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }


    public void clickRed(View view){
        Intent i = new Intent(UpdateActivity.this, MainActivity.class);
        startActivity(i);
    }

}