package com.androidapp.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class ngolist extends AppCompatActivity {

    Spinner spinner;
    Intent intent,chooser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_list);
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==0){


                }
                if(i==1){

                    startActivity(new Intent(ngolist.this,nofoodwaste.class) );
                }
                if(i==2){


                    startActivity(new Intent(ngolist.this,feedingindia.class) );
                }
                if(i==3){

                    startActivity(new Intent(ngolist.this,happyfridge.class) );
                }
                if(i==4){


                    startActivity(new Intent(ngolist.this,rotibank.class) );
                }
                if(i==5){
                    startActivity(new Intent(ngolist.this,santhimandiram.class) );
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}

