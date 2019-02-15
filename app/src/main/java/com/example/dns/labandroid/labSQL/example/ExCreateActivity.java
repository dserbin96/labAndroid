package com.example.dns.labandroid.labSQL.example;

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
//активити для заполнении иформации
public class ExCreateActivity extends AppCompatActivity {

    //поля для заполнения
    private EditText etName;
    private EditText etAge;
    private EditText etGroup;
    private EditText etNumber;
    //база данных
    private ExampleDBHalper dbHalper;
    private Button btnAdd;
    private Button btnOpen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_create);

        //инициализируем нашу БД
        dbHalper = new ExampleDBHalper(this);

        //инициализируем поля
        etName = findViewById(R.id.etFio);
        etAge = findViewById(R.id.etAge);
        etGroup = findViewById(R.id.etGroup);
        etNumber = findViewById(R.id.etNumber);
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
                //переходим на другой экран для просмотра данных в БД
                startActivity(new Intent(ExCreateActivity.this, ExStudentsActivity.class));
            }
        });
    }

    private void addStudent() {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String group = etGroup.getText().toString();
        String number = etNumber.getText().toString();

        //обращаемся к БД для добавления информации в нее
        SQLiteDatabase db = dbHalper.getWritableDatabase();

        //создаем объект в который будет вноситься вся информациия
        //предоставляемая из заданных полей
        ContentValues contentValues = new ContentValues();
        //заполняем объект вносимый в БД
        contentValues.put(HostelContract.GuestEntry.COLUME_FIO, name);
        contentValues.put(HostelContract.GuestEntry.COLUME_AGE, age);
        contentValues.put(HostelContract.GuestEntry.COLUME_GROUP, group);
        contentValues.put(HostelContract.GuestEntry.COLUME_NUMBER_HOSTEL, number);
        //добавляем в таблицу всю внесенную информацию
        db.insert(HostelContract.GuestEntry.TABLE_NAME, null, contentValues);
    }
}
