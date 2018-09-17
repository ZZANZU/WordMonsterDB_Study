package com.tistory.dayglo.wordmonsterdb_study;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertRow() {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL(DBContract.SQL_INSERT + "('hi', '안녕', 1, 20180917)");
        db.close();
    }

    public String getAllData() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DBContract.WORD_TABLE_1, null);

        String resultData = "";
        while(cursor.moveToNext()) {
            resultData += cursor.getString(0) + " : "
                    + cursor.getString(1)
                    + cursor.getString(2)
                    + cursor.getString(3)
                    + "\n";
        }

        return resultData;
    }
}
