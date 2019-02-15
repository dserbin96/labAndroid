package com.example.dns.labandroid.labSQL.four;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dns.labandroid.R;

public class FourCreateActivity extends AppCompatActivity {

    private FourDBHalper dbHalper;

    private EditText etName;
    private EditText etAge;
    private EditText etYear;
    private EditText etSity;
    private Button btnAdd;
    private Button btnOpen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_create);

        dbHalper = new FourDBHalper(this);
        initView();
    }

    private void addStudent() {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String year = etYear.getText().toString();
        String sity = etSity.getText().toString();

        SQLiteDatabase db = dbHalper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DrafteeContract.GuestEntry.COLUME_FIO, name);
        contentValues.put(DrafteeContract.GuestEntry.COLUME_AGE, age);
        contentValues.put(DrafteeContract.GuestEntry.COLUME_YEAR, year);
        contentValues.put(DrafteeContract.GuestEntry.COLUME_SITY, sity);
        db.insert(DrafteeContract.GuestEntry.TABLE_NAME, null, contentValues);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etYear = findViewById(R.id.etYear);
        etSity = findViewById(R.id.etSity);

        btnAdd = findViewById(R.id.btnAdd);
        btnOpen = findViewById(R.id.btnOpen);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FourCreateActivity.this, FourDrafteeActivity.class));
            }
        });
    }
}
