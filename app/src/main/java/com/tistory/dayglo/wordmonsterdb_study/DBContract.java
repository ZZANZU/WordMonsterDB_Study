package com.tistory.dayglo.wordmonsterdb_study;

public class DBContract {
    private DBContract() {};

    // 테이블 이름(7개) 선언
    public static final String[] WORD_TABLE = {"WORD_DB_1", "WORD_DB_2", "WORD_DB_3", "WORD_DB_4",
                                                "WORD_DB_5", "WORD_DB_6", "WORD_DB_7"};

    // 컬럼값들 선언
    public static final String COL_ID = "_id";
    public static final String COL_WORD_EN = "WORD_EN";
    public static final String COL_WORD_KR = "WORD_KR";
    public static final String COL_DIFF_SCALE = "DIFF_SCALE";
    public static final String COL_TIME = "TIME";
}
