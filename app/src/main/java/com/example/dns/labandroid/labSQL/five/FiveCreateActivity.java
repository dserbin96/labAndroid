package com.example.dns.labandroid.labSQL.five;

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

public class FiveCreateActivity extends AppCompatActivity {

    private FiveDBHalper dbHalper;

    private EditText etName;
    private Spinner spinnerCourse;
    private EditText etAge;
    private Spinner spinnerCountry;
    private Spinner spinnerSex;
    private Button btnAdd;
    private Button btnOpen;

    private int country;
    private int course;
    private int sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_create);

        dbHalper = new FiveDBHalper(this);
        initView();
        initSpinner();
    }

    private void addStudent() {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        int positionCountry = spinnerCountry.getSelectedItemPosition();
        int positionSex = spinnerSex.getSelectedItemPosition();
        int positionCourse = spinnerCourse.getSelectedItemPosition();

        SQLiteDatabase db = dbHalper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(StudentsContract.GuestEntry.COLUME_FIO, name);
        contentValues.put(StudentsContract.GuestEntry.COLUME_AGE, age);
        contentValues.put(StudentsContract.GuestEntry.COLUME_COUNTRY, positionCountry);
        contentValues.put(StudentsContract.GuestEntry.COLUME_COURSE, positionCourse);
        contentValues.put(StudentsContract.GuestEntry.COLUME_SEX, positionSex);

        db.insert(StudentsContract.GuestEntry.TABLE_NAME, null, contentValues);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        spinnerSex = findViewById(R.id.spinnerSex);

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
                startActivity(new Intent(FiveCreateActivity.this, FiveStudentsActivity.class));
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter countryAdapter = ArrayAdapter.createFromResource(this, R.array.country,
                android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerCountry.setAdapter(countryAdapter);
        spinnerCountry.setSelection(0);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country = 0;
            }
        });

        ArrayAdapter courseAdapter = ArrayAdapter.createFromResource(this, R.array.course,
                android.R.layout.simple_spinner_item);
        courseAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerCourse.setAdapter(courseAdapter);
        spinnerCourse.setSelection(0);
        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                course = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                course = 0;
            }
        });

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
    }
}
