package com.tistory.dayglo.wordmonsterdb_study;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS WORD_DB_1 (NUM INTEGER, WORD_EN TEXT)";
    public static String INSERT_ROW = "INSERT INTO WORD_DB_1 (NUM, WORD_EN) VALUES (1, 'word1')";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertRow() {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL(INSERT_ROW);
        db.close();
    }

    public String getAllData() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM WORD_DB_1", null);

        String resultData = "";
        while(cursor.moveToNext()) {
            resultData += cursor.getString(0) + " : "
                    + cursor.getString(1);
        }

        return resultData;
    }
}
