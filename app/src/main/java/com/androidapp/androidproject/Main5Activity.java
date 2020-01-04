package com.androidapp.androidproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main5Activity extends AppCompatActivity {

    EditText er1, er2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        er1 = findViewById(R.id.ed11);
        er2 = findViewById(R.id.ed22);

        mAuth = FirebaseAuth.getInstance();
    }

    public void login(View view) {

        String email1 = er1.getText().toString();
        String pass1 = er2.getText().toString();

        switch (view.getId())
        {

            case R.id.btn2:
                mAuth.signInWithEmailAndPassword(email1,pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Main5Activity.this, "signed in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Main5Activity.this,MainActivity.class));

                        }
                        else
                            Toast.makeText(Main5Activity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn:
                startActivity(new Intent(Main5Activity.this,register.class));

                break;
        }

    }
    }
