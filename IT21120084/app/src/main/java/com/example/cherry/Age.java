package com.example.cherry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Age extends AppCompatActivity {

    TextView ag, gen;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        ag = findViewById(R.id.age);
        gen = findViewById(R.id.gender);
        next = findViewById(R.id.nextbtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Age.this, weight_tracker2.class);
                intent.putExtra("Age", ag.getText().toString().trim());
                intent.putExtra("Gender", gen.getText().toString().trim());
                startActivity(intent);



            }
        });

        Intent intent2 = getIntent();
        ag.setText(intent2.getStringExtra("Age1"));
        gen.setText(intent2.getStringExtra("gender1"));

    }
}