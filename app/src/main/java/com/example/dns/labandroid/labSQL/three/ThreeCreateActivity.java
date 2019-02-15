package com.example.dns.labandroid.labSQL.three;

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
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.dns.labandroid.R;

public class ThreeCreateActivity extends AppCompatActivity {

    private ThreeDBHalper dbHalper;

    private EditText etName;
    private EditText etAge;
    private Spinner spinnerBlood;
    private RadioButton positive;
    private RadioButton negative;
    private Button btnAdd;
    private Button btnOpen;

    private int blood;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_create);

        dbHalper = new ThreeDBHalper(this);
        initView();
        initSpinner();
    }

    private void addStudent() {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();

        SQLiteDatabase db = dbHalper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PatientContract.GuestEntry.COLUME_FIO, name);
        contentValues.put(PatientContract.GuestEntry.COLUME_AGE, age);
        contentValues.put(PatientContract.GuestEntry.COLUME_BLOOD, blood);
        contentValues.put(PatientContract.GuestEntry.COLUME_TYPE_BLOOD, positive.isChecked() ? 1 : 0);

        db.insert(PatientContract.GuestEntry.TABLE_NAME, null, contentValues);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        spinnerBlood = findViewById(R.id.spinnerBlood);
        positive = findViewById(R.id.positive);
        negative = findViewById(R.id.negative);

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
                startActivity(new Intent(ThreeCreateActivity.this, ThreePatientActivity.class));
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter bloodAdapter = ArrayAdapter.createFromResource(this, R.array.blood,
                android.R.layout.simple_spinner_item);
        bloodAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerBlood.setAdapter(bloodAdapter);
        spinnerBlood.setSelection(0);
        spinnerBlood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                blood = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                blood = 0;
            }
        });
    }
}
