package com.androidapp.androidproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    SQLiteHelper(Context context,
                 String name,
                 SQLiteDatabase.CursorFactory factory,
                 int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String name, String destination, String date, byte[] image) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO RECORD VALUES (NULL, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, destination);
        statement.bindString(3, date);
        statement.bindBlob(4,image);
        statement.executeInsert();
    }
    public void updateData(String name, String destination, String date, byte[] image,  int id) {
        SQLiteDatabase database = getWritableDatabase();
        // query to update record
        String sql = "UPDATE RECORD SET name = ?, destination = ?, date = ?, image = ? WHERE id=?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindString(1, name);
        statement.bindString(2, destination);
        statement.bindString(3, date);
        statement.bindBlob(4, image);

        statement.bindDouble(5, (double) id);

        statement.execute();
        database.close();
    }



    public void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE  FROM RECORD WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();

    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getdata(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

}
