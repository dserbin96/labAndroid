package com.example.dns.labandroid.labSQL.example;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dns.labandroid.R;
//активити которая показывает все содержимое БД
public class ExStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_student);

        //инициализирум текст для его заолнения
        TextView tvStudents = findViewById(R.id.tvStudents);
        //инициализируем бд
        ExampleDBHalper dbHalper = new ExampleDBHalper(this);

        //обращаемся к бд для ее чтения
        SQLiteDatabase db = dbHalper.getReadableDatabase();
        //создаем массив из колонок находящихся в таблице
        String[] arrayColumn = {
                HostelContract.GuestEntry.COLUME_ID,
                HostelContract.GuestEntry.COLUME_FIO,
                HostelContract.GuestEntry.COLUME_NUMBER_HOSTEL,
                HostelContract.GuestEntry.COLUME_AGE,
                HostelContract.GuestEntry.COLUME_GROUP};

        //создаем курсор с помощью которого будем осуществлять чтение бд
        //указываем название таблици и какие колонки таблици нам нужны
        //остальные поля не пригодятся
        Cursor cursor = db.query(HostelContract.GuestEntry.TABLE_NAME,
                arrayColumn,
                null,
                null,
                null,
                null,
                null);

        //узнаем индекс каждой колонки в таблице
        int indexId = cursor.getColumnIndex(HostelContract.GuestEntry.COLUME_ID);
        int indexFio = cursor.getColumnIndex(HostelContract.GuestEntry.COLUME_FIO);
        int indexNumber = cursor.getColumnIndex(HostelContract.GuestEntry.COLUME_NUMBER_HOSTEL);
        int indexAge = cursor.getColumnIndex(HostelContract.GuestEntry.COLUME_AGE);
        int indexGroup = cursor.getColumnIndex(HostelContract.GuestEntry.COLUME_GROUP);

        //добавляем навание колонок в наш текст
        String columns = HostelContract.GuestEntry.COLUME_ID + " " +
                HostelContract.GuestEntry.COLUME_FIO + " " +
                HostelContract.GuestEntry.COLUME_NUMBER_HOSTEL + " " +
                HostelContract.GuestEntry.COLUME_AGE + " " +
                HostelContract.GuestEntry.COLUME_GROUP + " \n";
        tvStudents.append(columns);

        //с помощью курсора считывам каждую строку
        while (cursor.moveToNext()) {
            //по индексу выбираем значения из БД
            int id = cursor.getInt(indexId);
            String fio = cursor.getString(indexFio);
            int number = cursor.getInt(indexNumber);
            int age = cursor.getInt(indexAge);
            String group = cursor.getString(indexGroup);

            //добавляем в такст значения
            String row = String.valueOf(id) + " " +
                    fio + " " +
                    String.valueOf(number) + " " +
                    String.valueOf(age) + " " +
                    group + " \n";

            tvStudents.append(row);
        }

        //закрываем курсор для завершения работы
        //если не сделать этого то может возникнуть утечка памяти
        cursor.close();
    }
}
