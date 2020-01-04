package com.androidapp.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Event_planner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_planner);
    }
    public void eventp(View view) {
        switch (view.getId()){

            case R.id.imgView1:
                startActivity(new Intent(this,birthday.class));
                break;


            case R.id.imgView2:
                startActivity(new Intent(this,anniversey.class));
                break;

            case R.id.imgView3:
                startActivity(new Intent(this,kitty.class));
                break;

            case R.id.imgView4:
                startActivity(new Intent(this,farewell.class));
                break;


        }
    }
}
