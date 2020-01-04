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

public class register extends AppCompatActivity {
    EditText er3, er4;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        er3 = findViewById(R.id.ed3);
        er4 = findViewById(R.id.ed4);
        mAuth = FirebaseAuth.getInstance();

    }

    public void register(View view) {

        String email_txt = er3.getText().toString();
        String pass_txt = er4.getText().toString();

        switch (view.getId())
        {
            case R.id.btn:
                mAuth.createUserWithEmailAndPassword(email_txt,pass_txt).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "Registered", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(register.this,MainActivity.class));
                            finish();
                        }
                        else
                            Toast.makeText(register.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn2:
               startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }
}
