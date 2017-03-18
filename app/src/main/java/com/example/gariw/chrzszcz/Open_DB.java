package com.example.gariw.chrzszcz;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

/**
 * Created by Gariw on 2016-11-02.
 */

public class Open_DB extends AppCompatActivity {
    String TABLE_NAME = "slowka";

    public Cursor db(Context context){
        Cursor c = null;
        DatabaseHelper myDbHelper = new DatabaseHelper(context);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        c = myDbHelper.query(TABLE_NAME, null, null, null, null, null, null);
        return c;
    }
}