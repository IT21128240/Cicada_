package com.example.cherry;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Customize2 extends AppCompatActivity {

    EditText evol;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize2);


        evol = findViewById(R.id.editvol);
        create = findViewById(R.id.customize);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper d1 = new DBhelper(Customize2.this);
                int data = Integer.parseInt(evol.getText().toString().trim());
                d1.insertCust(data);
            }
        });

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skblue)));

    }
}