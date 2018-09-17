package com.tistory.dayglo.wordmonsterdb_study;

public class DBContract {
    private DBContract() {};

    // 컬럼값들 선언
    public static final String WORD_TABLE_1 = "WORD_DB_1";
    public static final String COL_WORD_EN = "WORD_EN";
    public static final String COL_WORD_KR = "WORD_KR";
    public static final String COL_DIFF_SCALE = "DIFF_SCALE";
    public static final String COL_TIME = "TIME";

    // CREATE TABLE
    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + WORD_TABLE_1 + " " +
            "(" +
            COL_WORD_EN     +   " TEXT"     +   ", " +
            COL_WORD_KR     +   " TEXT"     +   ", " +
            COL_DIFF_SCALE  +   " INTEGER"  +   ", " +
            COL_TIME        +   " INTEGER"  +
            ")";

    // INSERT ROW
    public static final String SQL_INSERT = "INSERT INTO " + WORD_TABLE_1 + " " +
            "(" +
            COL_WORD_EN + ", " +
            COL_WORD_KR + ", " +
            COL_DIFF_SCALE + ", " +
            COL_TIME +
            ") VALUES ";
}
