package com.tistory.dayglo.wordmonsterdb_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "wordmonster.db", null, 1);

        Button insertBtn = findViewById(R.id.insert_btn);
        Button getWordWindowBtn = findViewById(R.id.get_word_window_btn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ZZANZU", "insert data to DB : " + dbHelper.getAllData(0));
            }
        });

        getWordWindowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.makeWordWindow(6);
            }
        });
    }
}
