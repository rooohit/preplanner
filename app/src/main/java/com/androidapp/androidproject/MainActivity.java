package com.androidapp.androidproject;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static SQLiteHelper mSQLiteHelper;
    TextView t;
    EditText er1, er2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        t = findViewById(R.id.text);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/strato.ttf");
        t.setTypeface(font);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search_history) {
            Toast.makeText(this, "you selected search history", Toast.LENGTH_SHORT).show();

            return true;
        }
        if (id == R.id.action_recent_location) {
            Toast.makeText(this, "you selected recent location", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit");
            builder.setMessage("Do you want to close the app?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("NO", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent, chooser;
         switch (item.getItemId()){
              case R.id.nav_setting: {
                 Toast.makeText(this, "you selected setting", Toast.LENGTH_SHORT).show();
                  Intent z =new Intent(MainActivity.this,Main5Activity.class);
                  startActivity(z);

                  break;
                 // Handle the camera action
             }case R.id.nav_feedback: {
                 intent = new Intent(Intent.ACTION_SEND);
                 intent.setData(Uri.parse("mailto:"));
                 String[] to = {"roohitsingh17@gmail.com"};
                 intent.putExtra(Intent.EXTRA_EMAIL, to);
                 intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback Form of user");
                 intent.putExtra(Intent.EXTRA_TEXT, " My feedback is :");
                 intent.setType("text/plain");
                 chooser = Intent.createChooser(intent, "Share Feedback");
                 startActivity(chooser);
                 break;
             }case  R.id.nav_help: {
                 intent = new Intent(Intent.ACTION_VIEW);
                 intent.setData(Uri.parse("http://aptronnoida.in/"));
                 chooser = Intent.createChooser(intent, "Open Web");
                 startActivity(chooser);
                 break;
             }case R.id.nav_rate: {
                 Toast.makeText(this, "you selected rating", Toast.LENGTH_SHORT).show();

                 break;
             }case R.id.nav_share: {
                 intent = new Intent(Intent.ACTION_SEND);
                 intent.setType("text/plain");
                 intent.setPackage("com.whatsapp");
                 intent.putExtra(Intent.EXTRA_SUBJECT, "Hi this is my app. Download the app via click on given link");
                 intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.tencent.ig ");
                 try {
                     startActivity(intent);

                 } catch (android.content.ActivityNotFoundException ex) {
                     Toast.makeText(this, "whatsapp is not installed", Toast.LENGTH_SHORT).show();
                 }
                 break;

             }case R.id.nav_contact: {
                 intent = new Intent(Intent.ACTION_DIAL);
                 intent.setData(Uri.parse("tel:8076217463"));
                 chooser = Intent.createChooser(intent, "Open Dial");
                 startActivity(chooser);
                 break;
             }case R.id.nav_logout: {
                 Toast.makeText(this, "you selected logout", Toast.LENGTH_SHORT).show();
                 break;
             }

         }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void action(View view) {

        Button bt1, bt2, bt3, bt4;
        bt1 = findViewById(R.id.button1);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(this, "you selected button 1", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,Main3Activity.class));
                break;
            case R.id.button2:
                Intent i =new Intent(MainActivity.this,Event_planner.class);
                startActivity(i);
                Toast.makeText(this, "you selected button 2", Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                Intent k =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(k);
                Toast.makeText(this, "you selected button 3", Toast.LENGTH_LONG).show();
                break;
            case R.id.button4:
                Intent j =new Intent(MainActivity.this,m4.class);
                startActivity(j);
                Toast.makeText(this, "you selected button 4", Toast.LENGTH_LONG).show();
                break;
        }
    }


    public void eventp(View view) {
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
                            Toast.makeText(MainActivity.this, "signed in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,MainActivity.class));

                        }
                        else
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn:
                startActivity(new Intent(MainActivity.this,register.class));

                break;
        }

    }
    }
