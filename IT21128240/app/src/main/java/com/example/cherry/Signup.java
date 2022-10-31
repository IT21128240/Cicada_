package com.example.cherry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {

    EditText email, password, repassword;
    Button signup, signin;
   // DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.editTextNumberDecimal);
        password = findViewById(R.id.enterpassword);
        signup = findViewById(R.id.signbtn);
        signin = findViewById(R.id.btnsignin);
        repassword = findViewById(R.id.repassword);


//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = email.getText().toString();
//                String pass = password.getText().toString();
//                String repass = repassword.getText().toString();

//                if(user.equals("")||pass.equals("")||repass.equals(""))
//                    Toast.makeText(Signup.this, "PLEASE ENTER ALL THE FIELDS", Toast.LENGTH_SHORT).show();
//                else{
//                    if(pass.equals(repass)){
//                       Boolean checkuser = DB.checkusername(user);
//                       if(checkuser == false){
//                            Boolean insert = DB.insertData(user, pass);
//                           if(insert == true){
//                                Toast.makeText(Signup.this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(), Water_Tracker2.class);
//                                startActivity(intent);
//                            }else{
//                                Toast.makeText(Signup.this, "REGISTRATION FAILED", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        else {
//                            Toast.makeText(Signup.this, "USER ALREADY EXISTS ! PLEASE SIGN IN", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else{
//                        Toast.makeText(Signup.this, "PASSWORD NOT MATCHING", Toast.LENGTH_SHORT).show();
//                    }
               }

            }











