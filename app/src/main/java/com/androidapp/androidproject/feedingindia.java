package com.androidapp.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class feedingindia extends AppCompatActivity {
    Button button;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedingindia);
        button = findViewById(R.id.bt2);
        textView=findViewById(R.id.text4);
    }
    public void event1(View view) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:90877 90877"));
                startActivity(intent);
            }
        });
    }
    public void event2(View view){

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent,chooser;
                intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to={" contact@feedingindia.org"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback form");
                intent.putExtra(Intent.EXTRA_TEXT,"I want To Volunteer");
                intent.setType("text/plain");
                chooser=Intent.createChooser(intent,"Share feedback");
                startActivity(chooser);

            }
        });
    }

}
