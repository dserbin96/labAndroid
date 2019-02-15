package com.example.dns.labandroid.labSQL.five;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dns.labandroid.R;

public class FiveStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_student);

        TextView tvStudents = findViewById(R.id.tvStudents);
        FiveDBHalper dbHalper = new FiveDBHalper(this);

        SQLiteDatabase db = dbHalper.getReadableDatabase();

        String[] arrayColumn = {
                StudentsContract.GuestEntry.COLUME_ID,
                StudentsContract.GuestEntry.COLUME_FIO,
                StudentsContract.GuestEntry.COLUME_COURSE,
                StudentsContract.GuestEntry.COLUME_AGE,
                StudentsContract.GuestEntry.COLUME_COUNTRY,
                StudentsContract.GuestEntry.COLUME_SEX};

        Cursor cursor = db.query(StudentsContract.GuestEntry.TABLE_NAME,
                arrayColumn,
                null,
                null,
                null,
                null,
                null);

        int indexId = cursor.getColumnIndex(StudentsContract.GuestEntry.COLUME_ID);
        int indexFio = cursor.getColumnIndex(StudentsContract.GuestEntry.COLUME_FIO);
        int indexCourse = cursor.getColumnIndex(StudentsContract.GuestEntry.COLUME_COURSE);
        int indexAge = cursor.getColumnIndex(StudentsContract.GuestEntry.COLUME_AGE);
        int indexCountry = cursor.getColumnIndex(StudentsContract.GuestEntry.COLUME_COUNTRY);
        int indexSex = cursor.getColumnIndex(StudentsContract.GuestEntry.COLUME_SEX);

        String columns = StudentsContract.GuestEntry.COLUME_ID + " " +
                StudentsContract.GuestEntry.COLUME_FIO + " " +
                StudentsContract.GuestEntry.COLUME_COURSE + " " +
                StudentsContract.GuestEntry.COLUME_AGE + " " +
                StudentsContract.GuestEntry.COLUME_COUNTRY + " " +
                StudentsContract.GuestEntry.COLUME_SEX + " \n";
        tvStudents.append(columns);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(indexId);
            String fio = cursor.getString(indexFio);
            String courseStud = getResources()
                    .getStringArray(R.array.course)[cursor.getInt(indexCourse)];
            String age = cursor.getString(indexAge);
            String countryStud = getResources()
                    .getStringArray(R.array.country)[cursor.getInt(indexCountry)];
            String sexStud = getResources()
                    .getStringArray(R.array.sex)[cursor.getInt(indexSex)];

            String row = String.valueOf(id) + " " +
                    fio + " " +
                    courseStud + " " +
                    String.valueOf(age) + " " +
                    countryStud + " " +
                    sexStud + " \n";

            tvStudents.append(row);
        }

        cursor.close();
    }
}
