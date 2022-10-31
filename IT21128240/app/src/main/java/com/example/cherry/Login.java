package com.example.cherry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = findViewById(R.id.email);
        final TextView password = findViewById(R.id.loginpassword);
        final Button loginBtn = findViewById(R.id.signbtn);
        final TextView signupnow = findViewById(R.id.signup);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailT = email.getText().toString();
                final String passT = password.getText().toString();

                if(emailT.isEmpty() || passT.isEmpty()){
                    Toast.makeText(Login.this,"Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });

        signupnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //open Register activity
                startActivity(new Intent(Login.this, Signup.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
}