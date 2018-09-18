package com.tistory.dayglo.wordmonsterdb_study;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class DBContract {
    private DBContract() {};

    // 테이블 이름(6개) 선언
    public static final String[] WORD_TABLE = {"WORD_DB_1", "WORD_DB_2", "WORD_DB_3", "WORD_DB_4", "WORD_DB_5", "WORD_DB_6"};

    // 컬럼값들 선언
    public static final String COL_WORD_EN = "WORD_EN";
    public static final String COL_WORD_KR = "WORD_KR";
    public static final String COL_DIFF_SCALE = "DIFF_SCALE";
    public static final String COL_TIME = "TIME";

    // INSERT ROW
    public static final String SQL_INSERT = "INSERT INTO " + WORD_TABLE[3] + " " +
            "(" +
            COL_WORD_EN + ", " +
            COL_WORD_KR + ", " +
            COL_DIFF_SCALE + ", " +
            COL_TIME +
            ") VALUES ";

    // 데이터 테이블 생성 쿼리 배열(WORD_TABLE_1 ~ WORD_TABLE_6)
    public static String[] getCreateQuery() {
        String[] createQuery = new String[6];

        for(int i = 0; i < 6; i++) {
            createQuery[i] = "CREATE TABLE IF NOT EXISTS " + WORD_TABLE[i] + " " +
                    "(" +
                    COL_WORD_EN     +   " TEXT"     +   ", " +
                    COL_WORD_KR     +   " TEXT"     +   ", " +
                    COL_DIFF_SCALE  +   " INTEGER"  +   ", " +
                    COL_TIME        +   " INTEGER"  +
                    ")";
        }

        return createQuery;
    }

}
