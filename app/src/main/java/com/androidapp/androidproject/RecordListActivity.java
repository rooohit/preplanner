package com.androidapp.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class RecordListActivity extends AppCompatActivity {

    ListView mListView;


    ArrayList<Model> mList;
    RecordListAdapter mAdapter =null;

    ImageView imageViewIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);
        mListView =(ListView) findViewById(R.id.listView) ;
        mList =new ArrayList<>();
        mAdapter = new RecordListAdapter(this,R.layout.row, mList);
        mListView.setAdapter((ListAdapter) mAdapter);
        Cursor cursor = Main3Activity.mSQLiteHelper.getData(" SELECT * FROM RECORD");
        mList.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String destination = cursor.getString(2);
            String date = cursor.getString(3);
            byte[] image = cursor.getBlob(4);


            mList.add(new Model(id, name, destination, date, image));
        }
        mAdapter.notifyDataSetChanged();


        // yaha check kro ye if syd hatana pdega


        if ( mList.size()==0){

            Toast.makeText(this, "No record found... ", Toast.LENGTH_SHORT).show();

        }

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long l) {

                CharSequence[] items = {"Update","Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(RecordListActivity.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override                          // yha dekh lo ek baar
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i==0){

                            Cursor c= Main3Activity.mSQLiteHelper.getData("SELECT id FROM RECORD");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogUpdate(RecordListActivity.this,arrID.get(position));

                        }
                        else  {

                            Cursor c = Main3Activity.mSQLiteHelper.getData("SELECT id FROM RECORD");
                            ArrayList<Integer> arrId = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrId.add( c.getInt(0));
                            }
                            showDialogDelete(arrId.get(position));
                        }
                    }
                });
                dialog.show();

                return true;
            }
        });

    }

    private void showDialogUpdate (Activity activity, final int position) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.update_dialog);
        dialog.setTitle("Update");

        imageViewIcon = (ImageView) dialog.findViewById(R.id.imageViewRecord);
        final EditText edtName = (EditText) dialog.findViewById(R.id.edtName);
        final EditText edtDestination = (EditText) dialog.findViewById(R.id.edtDestination);
        final EditText edtDate = (EditText) dialog.findViewById(R.id.edtDate);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        //get data of row clicked from splite
        Cursor cursor = Main3Activity.mSQLiteHelper.getData(" SELECT * FROM RECORD WHERE id="+position);
        mList.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            edtName.setText(name); //set name to update dialog
            String destination = cursor.getString(2);
            edtDestination.setText(destination);
            String date = cursor.getString(3);
            edtDate.setText(date);
            byte[] image = cursor.getBlob(4);
//set image got from sqlite
            imageViewIcon.setImageBitmap(BitmapFactory.decodeByteArray(image,0,image.length));

            mList.add(new Model(id, name, destination, date, image));
        }




        // set width for dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        // set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.6);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imageViewIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityCompat.requestPermissions(
                        RecordListActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888

                );

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Main3Activity.mSQLiteHelper.updateData(
                            edtName.getText().toString().trim(),
                            edtDestination.getText().toString().trim(),
                            edtDate.getText().toString().trim(),
                            Main3Activity.imageViewToByte(imageViewIcon),
                            position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Update Successfull", Toast.LENGTH_SHORT).show();
                } catch (Exception error) {
                    Log.e("Update error", error.getMessage());
                }
                updateRecordList();

            }
        });
    }
    // yha check kro
    private void showDialogDelete ( final int idRecord){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(RecordListActivity.this);
        dialogDelete.setTitle("Warning !!");
        dialogDelete.setMessage("Are you sure to delete?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Main3Activity.mSQLiteHelper.deleteData(idRecord);
                    Toast.makeText (getApplicationContext(), "Delete successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
                updateRecordList();
            }
        });
        dialogDelete.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();

            }
        });
        dialogDelete.show();

    }

    private void updateRecordList() {


        Cursor cursor = Main3Activity.mSQLiteHelper.getdata("SELECT * FROM RECORD ");
        mList.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String destination = cursor.getString(2);
            String date = cursor.getString(3);
            byte[] image = cursor.getBlob(4);


            mList.add(new Model(id, name, destination, date, image));

        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 888 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewIcon.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void event(View view) {

        Intent intent,chooser;
        switch (view.getId())
        {
            case R.id.ticket:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.olacabs.com"));
                chooser =Intent.createChooser(intent,"Open Ola");
                startActivity(chooser);
                break;
            case R.id.shareLoc:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo://@28.5849512,77.3131489"));
                chooser =Intent.createChooser(intent,"Open Map");
                startActivity(chooser);
                break;
        }

    }
}
