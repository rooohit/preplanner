package com.androidapp.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class m4 extends AppCompatActivity {
    RecyclerView recyclerView;
    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m4);
        bt1=findViewById(R.id.button1);
        bt2=findViewById(R.id.button2);

    }

    public void event(View view) {

        switch (view.getId()){
            case R.id.button1:

                startActivity(new Intent(m4.this,ngolist.class));
                break;
            case  R.id.button2:
                startActivity(new Intent(m4.this,beggar.class));
                break;
        }
    }
}
