package com.example.cherry;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class weight_tracker3 extends AppCompatActivity {


    EditText blank;
    TextView display;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker3);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

        blank = findViewById(R.id.bmiblank);
        display = findViewById(R.id.display);
        delete = findViewById(R.id.delete);

        Intent intent = getIntent();
        String b = intent.getStringExtra("bmi");
        blank.setText(b);

        //Toast.makeText(this, "hello" +b, Toast.LENGTH_SHORT).show();

        float age = Float.parseFloat(b);
        if(age < 18.5){
            display.setText("UNDERWEIGHT RANGE");
        }
        else if(age >= 18.5 && age <=24.9){
            display.setText("HEALTHY WEIGHT RANGE");
        }
        else if(age >= 25.0 && age <= 29.9){
            display.setText("OVERWEIGHT RANGE");
        }
        else if (age > 30.0){
            display.setText("OBESE RANGE");
        }

        if(getIntent().hasExtra("bmi")){
            Toast.makeText(this, "sameer", Toast.LENGTH_SHORT).show();

        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHome();
            }
        });

    }



    public void goHome(){
            Intent intent3 = new Intent(weight_tracker3.this, Age.class);
            startActivity(intent3);


    }


}