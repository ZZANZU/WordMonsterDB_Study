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
        String[] createQuery = DBContract.getCreateQuery(); // 테이블 생성 쿼리
        for(int i = 0; i < createQuery.length; i++) {
            db.execSQL(createQuery[i]); // 테이블 생성
        }

        String[] insertTestWordQuery = DBContract.insertSampleDataQuery();
        for(int i = 0; i < insertTestWordQuery.length; i++) {
            db.execSQL(insertTestWordQuery[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String getAllData(int i) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DBContract.WORD_TABLE[i], null);

        String resultData = "";
        while(cursor.moveToNext()) {
            resultData += cursor.getString(0) + " : "
                    + cursor.getString(1) + " "
                    + cursor.getString(2) + " "
                    + cursor.getString(3) + " "
                    + cursor.getString(4)
                    + "\n";
        }

        return resultData;
    }
}
