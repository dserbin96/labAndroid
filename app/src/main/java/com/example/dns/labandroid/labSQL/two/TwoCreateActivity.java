package com.example.dns.labandroid.labSQL.two;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dns.labandroid.R;

public class TwoCreateActivity extends AppCompatActivity {

    private TwoDBHalper dbHalper;

    private EditText etName;
    private EditText etAge;
    private Spinner spinnerSex;
    private Spinner spinnerStatys;
    private Button btnAdd;
    private Button btnOpen;

    private int sex;
    private int statys;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_create);

        dbHalper = new TwoDBHalper(this);
        initView();
        initSpinner();
    }

    private void addStudent() {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();

        SQLiteDatabase db = dbHalper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TeacherContract.GuestEntry.COLUME_FIO, name);
        contentValues.put(TeacherContract.GuestEntry.COLUME_AGE, age);
        contentValues.put(TeacherContract.GuestEntry.COLUME_SEX, sex);
        contentValues.put(TeacherContract.GuestEntry.COLUME_STATYS, statys);

        db.insert(TeacherContract.GuestEntry.TABLE_NAME, null, contentValues);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        spinnerSex = findViewById(R.id.spinnerSex);
        spinnerStatys = findViewById(R.id.spinnerStatys);

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
                startActivity(new Intent(TwoCreateActivity.this, TwoTeacherActivity.class));
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter sexAdapter = ArrayAdapter.createFromResource(this, R.array.sex,
                android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerSex.setAdapter(sexAdapter);
        spinnerSex.setSelection(0);
        spinnerSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sex = 0;
            }
        });

        ArrayAdapter statysAdapter = ArrayAdapter.createFromResource(this, R.array.statys,
                android.R.layout.simple_spinner_item);
        statysAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerStatys.setAdapter(statysAdapter);
        spinnerStatys.setSelection(0);
        spinnerStatys.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statys = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                statys = 0;
            }
        });
    }
}
