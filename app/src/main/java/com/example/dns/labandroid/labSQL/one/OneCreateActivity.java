package com.example.dns.labandroid.labSQL.one;

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

public class OneCreateActivity extends AppCompatActivity {

    private OneDBHalper dbHalper;

    private EditText etName;
    private EditText etRating;
    private Spinner spinnerFormStudy;
    private Spinner spinnerTypeStudy;
    private Button btnAdd;
    private Button btnOpen;

    private int formOfStudy;
    private int typeOfStudy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_create);

        dbHalper = new OneDBHalper(this);
        initView();
        initSpinner();
    }

    private void addStudent() {
        String name = etName.getText().toString();
        String rating = etRating.getText().toString();

        SQLiteDatabase db = dbHalper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(EnrolleeContract.GuestEntry.COLUME_FIO, name);
        contentValues.put(EnrolleeContract.GuestEntry.COLUME_RATING, rating);
        contentValues.put(EnrolleeContract.GuestEntry.COLUME_FORM_OF_STUDY, formOfStudy);
        contentValues.put(EnrolleeContract.GuestEntry.COLUME_TYPE_OF_STUDY, typeOfStudy);

        db.insert(EnrolleeContract.GuestEntry.TABLE_NAME, null, contentValues);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etRating = findViewById(R.id.etRating);
        spinnerFormStudy = findViewById(R.id.spinnerFormStudy);
        spinnerTypeStudy = findViewById(R.id.spinnerTypeStudy);

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
                startActivity(new Intent(OneCreateActivity.this, OneEnrolleeActivity.class));
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter formOfStudyAdapter = ArrayAdapter.createFromResource(this, R.array.form_of_study,
                android.R.layout.simple_spinner_item);
        formOfStudyAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerFormStudy.setAdapter(formOfStudyAdapter);
        spinnerFormStudy.setSelection(0);
        spinnerFormStudy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                formOfStudy = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                formOfStudy = 0;
            }
        });

        ArrayAdapter typeOfStudyAdapter = ArrayAdapter.createFromResource(this, R.array.type_of_study,
                android.R.layout.simple_spinner_item);
        typeOfStudyAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerTypeStudy.setAdapter(typeOfStudyAdapter);
        spinnerTypeStudy.setSelection(0);
        spinnerTypeStudy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeOfStudy = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                typeOfStudy = 0;
            }
        });
    }
}
