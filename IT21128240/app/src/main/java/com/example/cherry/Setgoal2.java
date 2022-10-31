package com.example.cherry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Setgoal2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setgoal2);


//        EditText et;
//        Button bt1;
//
//        et=findViewById(R.id.editTextNumberDecimal);
//        bt1=findViewById(R.id.customize);
//
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DBhelper d1 = new DBhelper(Setgoal2.this);
//               int data = Integer.parseInt(et.getText().toString().trim());
//                d1.insertData(data);
//                goHome();
//            }
//       });




        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));
  }

    public void goHome(){
        Intent intent = new Intent(this, Water_Tracker2.class);
        startActivity(intent);
    }
}