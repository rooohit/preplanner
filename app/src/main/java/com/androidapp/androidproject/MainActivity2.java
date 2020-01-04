package com.androidapp.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {
    Spinner spinner;
        //This activity is for Trip planner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void event(View view) {
        switch (view.getId()) {
            case R.id.button1: {
                Intent i =new Intent(MainActivity2.this,FindPlace.class);
                startActivity(i);
                Toast.makeText(this, "you select button 1", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button2: {
                Toast.makeText(this, "you select button 2", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button3: {
                String link = "https://www.st-christophers.co.uk/travel-tips/blogs/2017/what-to-pack-in-your-travel-backpack";
                try {
                    Intent in = new Intent(Intent.ACTION_MAIN);
                    in.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    in.addCategory("android.intent.category.LAUNCHER");
                    in.setData(Uri.parse(link));
                    startActivity(in);
                } catch (ActivityNotFoundException e) {
                    //app is not installed
                    Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    startActivity(in);
                    Toast.makeText(this, "you select button 3", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            case R.id.button4: {
                Toast.makeText(this, "you select button 4", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button5: {
                Intent i =new Intent(MainActivity2.this,Sos.class);
                startActivity(i);
                Toast.makeText(this, "you select button 5", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}