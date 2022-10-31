package com.example.newapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Update_Activity extends AppCompatActivity {

    //data for dropdown list
    String[] endurance_Exercise =  {"Jogging" , "Swimming" , "Climbing hills", "Yard work" , "Walking briskly"};
    String[] strength_Exercise =  {"Lifting weights" , "Overhead arm curl" , "Arm curl", "Push-ups" , "Dumbbell Chopper"};
    String[] balance_Exercise =  {"Standing on one foot" , "The heel-to-toe walk" , "The balance walk", "Single leg lift" , "Balance on a stability ball"};
    String[] flexibility_Exercise =  {"The back stretch exercise" , "The inner thigh stretch" , "The ankle stretch", "The back of leg stretch" , "Seat Stretch"};

    //create objects
    Button hmBack , updateBtn , deleteBtn;

    TextView pName;

    String id, Title ,ex1 , ex2 ,ex3 ,ex4;

    EditText title;

    EditText editText , editText1 ,editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        //setting action bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionColor)));

        AutoCompleteTextView act1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        AutoCompleteTextView act2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        AutoCompleteTextView act3 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        AutoCompleteTextView act4 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView4);

        //assign all objects with frontend layout
        pName = findViewById(R.id.planName);
        updateBtn = findViewById(R.id.createBtn);
        hmBack = findViewById(R.id.hmBack);
        deleteBtn = findViewById(R.id.cancelBtn);
        title = findViewById(R.id.titlePlan);
        editText = (EditText)findViewById(R.id.textView2);
        editText1 = (EditText) findViewById(R.id.textView4);
        editText2 = (EditText) findViewById(R.id.textView6);
        editText3 = (EditText) findViewById(R.id.textView8);


        //creating array adapter for dropdown list and declare data for each dropdown list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Update_Activity.this, android.R.layout.simple_spinner_dropdown_item,endurance_Exercise);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Update_Activity.this, android.R.layout.simple_spinner_dropdown_item,strength_Exercise);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Update_Activity.this, android.R.layout.simple_spinner_dropdown_item,balance_Exercise);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Update_Activity.this, android.R.layout.simple_spinner_dropdown_item,flexibility_Exercise);

        //setting adapter
        act1.setAdapter(adapter);
        act2.setAdapter(adapter1);
        act3.setAdapter(adapter2);
        act4.setAdapter(adapter3);

        //getting plan data from view plan page
        getIntentData();

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


        //call functions for all buttons
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmationDialog();
            }
        });


        hmBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMain();
            }
        });

        //setting up plan name
       pName.setText(title.getText().toString().trim());



        //a specific plan will be updated after user clicks on UPDATE button
       updateBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //Validation - Check empty fields
               if(title.getText().toString().equals("")){
                   Toast.makeText(Update_Activity.this, " Enter a Plan Name :) ", Toast.LENGTH_SHORT).show();

               }else{

                   FDBHelper dbHelper = new FDBHelper(Update_Activity.this);
                   dbHelper.updateData(id , title.getText().toString().trim() , editText.getText().toString().trim() ,
                           editText1.getText().toString().trim(),editText2.getText().toString().trim(),
                           editText3.getText().toString().trim());
                   gotoMain();
               }

           }
       });

    }

    //set page for if user navigate back
    @Override
    public void onBackPressed() {
        gotoMain();
        super.onBackPressed();
    }

    //function declarations
    public void gotoMain(){
        Intent intent = new Intent(this,View_Plan.class);
        startActivity(intent);
    }

    //get intent that coming from view plan page and set values to correct fields
    void getIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("ex1") &&getIntent().hasExtra("ex2") && getIntent().hasExtra("ex3") && getIntent().hasExtra("ex4") ){
            id = getIntent().getStringExtra("id");
            Title = getIntent().getStringExtra("title");
            ex1 = getIntent().getStringExtra("ex1");
            ex2 = getIntent().getStringExtra("ex2");
            ex3 = getIntent().getStringExtra("ex3");
            ex4 = getIntent().getStringExtra("ex4");


            title.setText(Title);
            editText.setText(ex1);
            editText1.setText(ex2);
            editText2.setText(ex3);
            editText3.setText(ex4);

        }else{
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }
    }

    //Confirmation Dialog for Delete a Plan and a specific plan will be deleted after user clicks on DELETE button
    // (if user confirms it only)
    void confirmationDialog(){
        //creating confirmation dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + Title + " ?");
        builder.setMessage("Are you sure , You want to delete Plan " + Title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FDBHelper dbHelper = new FDBHelper(Update_Activity.this);
                dbHelper.deleteData(id);
                gotoMain();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

}