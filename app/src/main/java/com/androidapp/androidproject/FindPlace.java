package com.androidapp.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class FindPlace extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] places={"Select Places","Hot Places","Cold Places","Deserts","Indian Safari","Devotional Places","Ancient Places"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_place);
        Spinner spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa= new ArrayAdapter(this,android.R.layout.simple_spinner_item,places);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:{
                break;
            }
            case 1:{
                String link="https://www.indianholiday.com/blog/warm-weather-destinations-india/";
                try{
                    Intent in = new Intent(Intent.ACTION_MAIN);
                    in.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    in.addCategory("android.intent.category.LAUNCHER");
                    in.setData(Uri.parse(link));
                    startActivity(in);
                }
                catch (ActivityNotFoundException e){
                    //app is not installed
                    Intent in= new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                    startActivity(in);
                }
                break;
            }
            case 2:{
                String link="https://www.treebo.com/blog/places-to-visit-in-india-in-june/";
                try {
                    Intent in = new Intent(Intent.ACTION_MAIN);
                    in.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    in.addCategory("android.intent.category.LAUNCHER");
                    in.setData(Uri.parse(link));
                    startActivity(in);
                }
                catch (ActivityNotFoundException e){
                    //app is not installed
                    Intent in= new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                    startActivity(in);
                }
                break;
            }
            case 3:{
                String link="https://www.indianholiday.com/blog/warm-weather-destinations-india/";
                try {
                    Intent in = new Intent(Intent.ACTION_MAIN);
                    in.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    in.addCategory("android.intent.category.LAUNCHER");
                    in.setData(Uri.parse(link));
                    startActivity(in);
                }
                catch (ActivityNotFoundException e){
                    //app is not installed
                    Intent in= new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                    startActivity(in);
                }
                break;
            }
            case 4:{
                String link="https://www.tourmyindia.com/blog/india-top-places-for-wildlife-safari-holidays/";
                try {
                    Intent in = new Intent(Intent.ACTION_MAIN);
                    in.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    in.addCategory("android.intent.category.LAUNCHER");
                    in.setData(Uri.parse(link));
                    startActivity(in);
                }
                catch (ActivityNotFoundException e){
                    //app is not installed
                    Intent in= new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                    startActivity(in);
                }
                break;
            }
            case 5:{
                String link="https://www.tourmyindia.com/blog/top-25-religious-tourism-places-in-india/";
                try {
                    Intent in = new Intent(Intent.ACTION_MAIN);
                    in.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    in.addCategory("android.intent.category.LAUNCHER");
                    in.setData(Uri.parse(link));
                    startActivity(in);
                }
                catch (ActivityNotFoundException e){
                    //app is not installed
                    Intent in= new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                    startActivity(in);
                }
                break;
            }
            case 6:{
                String link="https://www.holidify.com/collections/historical-places-in-india";
                try {
                    Intent in = new Intent(Intent.ACTION_MAIN);
                    in.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    in.addCategory("android.intent.category.LAUNCHER");
                    in.setData(Uri.parse(link));
                    startActivity(in);
                }
                catch (ActivityNotFoundException e){
                    //app is not installed
                    Intent in= new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                    startActivity(in);
                }
                break;
            }
        }
        Toast.makeText(getApplicationContext(),places[i],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
