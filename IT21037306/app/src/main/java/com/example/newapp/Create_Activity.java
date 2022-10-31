package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_Activity extends AppCompatActivity {

    //data for dropdown list
    String[] endurance_Exercise =  {"Jogging" , "Swimming" , "Climbing hills", "Yard work" , "Walking briskly"};
    String[] strength_Exercise =  {"Lifting weights" , "Overhead arm curl" , "Arm curl", "Push-ups" , "Dumbbell Chopper"};
    String[] balance_Exercise =  {"Standing on one foot" , "The heel-to-toe walk" , "The balance walk", "Single leg lift" , "Balance on a stability ball"};
    String[] flexibility_Exercise =  {"The back stretch exercise" , "The inner thigh stretch" , "The ankle stretch", "The back of leg stretch" , "Seat Stretch"};

    //create objects
    Button bkHome , createPlan , cancelPlan;

    EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //setting action bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionColor)));

        //assign all objects with frontend layout
        bkHome = findViewById(R.id.hmBack);
        cancelPlan = findViewById(R.id.cancelBtn);
        createPlan = findViewById(R.id.createBtn);

        AutoCompleteTextView act1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        AutoCompleteTextView act2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        AutoCompleteTextView act3 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        AutoCompleteTextView act4 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView4);

        title = findViewById(R.id.titlePlan);
        EditText editText = (EditText)findViewById(R.id.textView2);
        EditText editText1 = (EditText) findViewById(R.id.textView4);
        EditText editText2 = (EditText) findViewById(R.id.textView6);
        EditText editText3 = (EditText) findViewById(R.id.textView8);


        //creating array adapter for dropdown list and declare data for each dropdown list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Create_Activity.this, android.R.layout.simple_spinner_dropdown_item,endurance_Exercise);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Create_Activity.this, android.R.layout.simple_spinner_dropdown_item,strength_Exercise);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Create_Activity.this, android.R.layout.simple_spinner_dropdown_item,balance_Exercise);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Create_Activity.this, android.R.layout.simple_spinner_dropdown_item,flexibility_Exercise);

        //setting adapter
        act1.setAdapter(adapter);
        act2.setAdapter(adapter1);
        act3.setAdapter(adapter2);
        act4.setAdapter(adapter3);

        //finally created working dropdown list
        act1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(adapterView.getItemAtPosition(i).toString());
                //Toast.makeText(getApplicationContext(),adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

        act2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText1.setText(adapterView.getItemAtPosition(i).toString());
                //Toast.makeText(getApplicationContext(),adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

        act3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText2.setText(adapterView.getItemAtPosition(i).toString());
                //Toast.makeText(getApplicationContext(),adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

        act4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText3.setText(adapterView.getItemAtPosition(i).toString());
                //Toast.makeText(getApplicationContext(),adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });


        //call functions for each buttons
        bkHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHome();
            }
        });

        cancelPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHome();
            }
        });

        //a plan will be created after user clicks on CREATE button
        createPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validation - Check empty fields
                if (title.getText().toString().equals("")){
                    Toast.makeText(Create_Activity.this, " Enter a Plan Name :) ", Toast.LENGTH_SHORT).show();
                } else if (editText.getText().toString().equals("")
                        || editText1.getText().toString().equals("") || editText2.getText().toString().equals("") ||
                        editText3.getText().toString().equals("")){
                    Toast.makeText(Create_Activity.this, "You must select an Exercise in each type",
                            Toast.LENGTH_SHORT).show();
                }else{
                    FDBHelper dbHelper = new FDBHelper(Create_Activity.this);
                    dbHelper.addPlan(title.getText().toString().trim(),editText.getText().toString().trim()
                            , editText1.getText().toString().trim() , editText2.getText().toString().trim() ,
                            editText3.getText().toString().trim());
                    gotoHome();
                }
            }
        });



    }

    //set page for if user navigate back
    @Override
    public void onBackPressed() {
        gotoHome();
        super.onBackPressed();
    }

    //function declarations
    public void gotoHome(){
        Intent intent = new Intent(this,View_Plan.class);
        startActivity(intent);
    }
}