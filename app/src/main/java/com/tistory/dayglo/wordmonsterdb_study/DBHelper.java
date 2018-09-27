package com.tistory.dayglo.wordmonsterdb_study;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.tistory.dayglo.wordmonsterdb_study.DBContract.COL_DIFF_SCALE;
import static com.tistory.dayglo.wordmonsterdb_study.DBContract.COL_TIME;
import static com.tistory.dayglo.wordmonsterdb_study.DBContract.COL_WORD_EN;
import static com.tistory.dayglo.wordmonsterdb_study.DBContract.COL_WORD_KR;
import static com.tistory.dayglo.wordmonsterdb_study.DBContract.WORD_TABLE;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] createQuery = getCreateQuery(); // 테이블 생성 쿼리
        for(int i = 0; i < createQuery.length; i++) {
            db.execSQL(createQuery[i]); // 테이블 생성
        }

        String[] insertTestWordQuery = insertSampleDataQuery();
        for(int i = 0; i < insertTestWordQuery.length; i++) {
            db.execSQL(insertTestWordQuery[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // i번째 테이블 데이터 조회.
    public String getAllData(int i) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + WORD_TABLE[i], null);

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

    // 데이터 테이블 생성 쿼리 배열(WORD_TABLE_1 ~ WORD_TABLE_6)
    public String[] getCreateQuery() {
        String[] createQuery = new String[WORD_TABLE.length];

        for(int i = 0; i < WORD_TABLE.length; i++) {
            createQuery[i] = "CREATE TABLE IF NOT EXISTS " + WORD_TABLE[i] + " " +
                    "(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT" + ", " +
                    COL_WORD_EN     +   " TEXT"     +   ", " +
                    COL_WORD_KR     +   " TEXT"     +   ", " +
                    COL_DIFF_SCALE  +   " INTEGER"  +   ", " +
                    COL_TIME        +   " INTEGER"  +
                    ")";
        }

        return createQuery;
    }

    // 샘플 데이터 추가, 하드코딩 ㅎㄷㄷ
    public String[] insertSampleDataQuery() {
        String[] insertTestWordQuery = new String[60];

        // 1번 테이블 데이터 입력
        for(int i = 0; i < 12; i++) {
            insertTestWordQuery[i] = "INSERT INTO " + WORD_TABLE[0] + " " +
                    "(" +
                    COL_WORD_EN + "," +
                    COL_WORD_KR + "," +
                    COL_DIFF_SCALE + "," +
                    COL_TIME +
                    ")" +
                    "VALUES " +
                    "("  +
                    "'word_example_1'" + ", " +
                    "'1table_ex_word'" + ", " +
                    "1" + ", " +
                    "20180921" +
                    ")";
        }

        // 2번 테이블 데이터 입력
        for(int i = 12; i < 25; i++) {
            insertTestWordQuery[i] = "INSERT INTO " + WORD_TABLE[1] + " " +
                    "(" +
                    COL_WORD_EN + "," +
                    COL_WORD_KR + "," +
                    COL_DIFF_SCALE + "," +
                    COL_TIME +
                    ")" +
                    "VALUES " +
                    "("  +
                    "'word_example_2'" + ", " +
                    "'2table_ex_word'" + ", " +
                    "2" + ", " +
                    "20180921" +
                    ")";
        }

        // 3번 테이블 데이터 입력
        for(int i = 25; i < 35; i++) {
            insertTestWordQuery[i] = "INSERT INTO " + WORD_TABLE[2] + " " +
                    "(" +
                    COL_WORD_EN + "," +
                    COL_WORD_KR + "," +
                    COL_DIFF_SCALE + "," +
                    COL_TIME +
                    ")" +
                    "VALUES " +
                    "("  +
                    "'word_example_3'" + ", " +
                    "'table_ex_word'" + ", " +
                    "3" + ", " +
                    "20180921" +
                    ")";
        }

        // 4번 테이블 데이터 입력
        for(int i = 35; i < 45; i++) {
            insertTestWordQuery[i] = "INSERT INTO " + WORD_TABLE[3] + " " +
                    "(" +
                    COL_WORD_EN + "," +
                    COL_WORD_KR + "," +
                    COL_DIFF_SCALE + "," +
                    COL_TIME +
                    ")" +
                    "VALUES " +
                    "("  +
                    "'word_example_4'" + ", " +
                    "'4table_ex_word'" + ", " +
                    "4" + ", " +
                    "20180921" +
                    ")";
        }

        // 5번 테이블 데이터 입력
        for(int i = 45; i < 55; i++) {
            insertTestWordQuery[i] = "INSERT INTO " + WORD_TABLE[4] + " " +
                    "(" +
                    COL_WORD_EN + "," +
                    COL_WORD_KR + "," +
                    COL_DIFF_SCALE + "," +
                    COL_TIME +
                    ")" +
                    "VALUES " +
                    "("  +
                    "'word_example_5'" + ", " +
                    "'5table_ex_word'" + ", " +
                    "5" + ", " +
                    "20180921" +
                    ")";
        }

        // 6번 테이블 데이터 입력
        for(int i = 55; i < 60; i++) {
            insertTestWordQuery[i] = "INSERT INTO " + WORD_TABLE[5] + " " +
                    "(" +
                    COL_WORD_EN + "," +
                    COL_WORD_KR + "," +
                    COL_DIFF_SCALE + "," +
                    COL_TIME +
                    ")" +
                    "VALUES " +
                    "("  +
                    "'word_example_6'" + ", " +
                    "'6table_ex_word'" + ", " +
                    "6" + ", " +
                    "20180921" +
                    ")";
        }

        return insertTestWordQuery;
    }

    // num개의 word window 생성(7번 테이블에 저장됨)
    public void makeWordWindow(int num) {
        SQLiteDatabase db = getReadableDatabase();

        for(int i = 0; i < 5; i++) {
            Cursor cursor = db.rawQuery("SELECT * FROM " + WORD_TABLE[i] + " ORDER BY RANDOM() LIMIT 1", null);

            if(cursor != null) {
                cursor.moveToFirst();

                moveRowToTable(cursor, 6);

                cursor.close();
            }
        }

        db.close();
    }

    // 단어 테이블의 특정 row를 cursor에 담아서 다른 테이블에 insert.
    public void moveRowToTable(Cursor cursor, int destTableNum) {
        SQLiteDatabase db = getWritableDatabase();

        if(cursor != null) {
            String WORD_EN = cursor.getString(1);
            String WORD_KR = cursor.getString(2);
            String DIFF_SCALE = cursor.getString(3);
            String TIME = cursor.getString(4);

            String INSERT_QUERY = "INSERT INTO " + WORD_TABLE[destTableNum] + " " +
                    "(" +
                    COL_WORD_EN + ", " +
                    COL_WORD_KR + ", " +
                    COL_DIFF_SCALE + ", " +
                    COL_TIME +
                    ")" +
                    " VALUES " +
                    "("  +
                    "'" + WORD_EN + "'" + ", " +
                    "'" + WORD_KR + "'" + ", " +
                    "'" + DIFF_SCALE + "'" + ", " +
                    "'" + TIME + "'" +
                    ")";

            db.execSQL(INSERT_QUERY);

            // TODO: 9/27/18 이동시킨 row를 기존 테이블에서 삭제하는 기능 추가
        }
    }
}
