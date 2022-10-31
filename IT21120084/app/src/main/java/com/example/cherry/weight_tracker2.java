package com.example.cherry;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class weight_tracker2 extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        EditText weight, height;
        Button calculate, edit;
        TextView age, gender;



        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        edit = findViewById(R.id.edit);



        Intent intent = getIntent();
        String a = intent.getStringExtra("Age");
        String b = intent.getStringExtra("Gender");

        age.setText(a);
        gender.setText(b);


        weight = findViewById(R.id.weight60);
        height = findViewById(R.id.height180);
        calculate = findViewById(R.id.nextbtn);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(weight_tracker2.this, Age.class);
                intent1.putExtra("Age1", a);
                intent1.putExtra("gender1", b);
                startActivity(intent1);
            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            DBhelper1 d1 = new DBhelper1(weight_tracker2.this);
            String w = weight.getText().toString().trim();
            float weight = Float.parseFloat(w);
            d1.insertData1(weight);

            String h = height.getText().toString().trim();
            float height = Float.parseFloat(h);
            d1.insertData2(height);


            float bmi =(weight/height/height)*10000;
            String sam = "" +bmi;

                //Toast.makeText(weight_tracker2.this, "BMI" +bmi, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(weight_tracker2.this,weight_tracker3.class);
              intent.putExtra("bmi", sam);

                startActivity(intent);

            }


        });


    }


}

//    EditText et;
//    Button bt1;
//
//        et=findViewById(R.id.editTextNumberDecimal);
//                bt1=findViewById(R.id.customize);
//
//                bt1.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        DBhelper d1 = new DBhelper(Setgoal2.this);
//        int data = Integer.parseInt(et.getText().toString().trim());
//        d1.insertData(data);
//        goHome();
//        }