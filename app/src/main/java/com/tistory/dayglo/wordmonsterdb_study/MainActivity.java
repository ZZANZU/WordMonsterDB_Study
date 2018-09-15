package com.tistory.dayglo.wordmonsterdb_study;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static String CREATE_TABLE = "CREATE TABLE IF NOT EXIST WORD_DB_1 (NO INTEGER, WORD_EN TEXT)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = null;

        try{
            db = SQLiteDatabase.openOrCreateDatabase("wordmonster.db", null);
            db.execSQL(CREATE_TABLE);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }
}
