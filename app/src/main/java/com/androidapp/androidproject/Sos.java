package com.androidapp.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Sos extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
    }

    public void sos(View view) {
        switch (view.getId()){
            case R.id.but1:{
                i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:100"));
                startActivity(i);
                break;

            }
            case R.id.but2:{
                i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:102"));
                startActivity(i);
                break;

            }
            case R.id.but3:{
                i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:181"));
                startActivity(i);
                break;

            }
            case R.id.but4:{
                i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:101"));
                startActivity(i);
                break;

            }
            case R.id.but5:{
                i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:108"));
                startActivity(i);
                break;

            }
        }
    }
}
