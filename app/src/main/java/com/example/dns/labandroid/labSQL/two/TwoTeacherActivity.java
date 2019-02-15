package com.example.dns.labandroid.labSQL.two;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dns.labandroid.R;

public class TwoTeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_student);

        TextView tvStudents = findViewById(R.id.tvStudents);
        TwoDBHalper dbHalper = new TwoDBHalper(this);

        SQLiteDatabase db = dbHalper.getReadableDatabase();

        String[] arrayColumn = {
                TeacherContract.GuestEntry.COLUME_ID,
                TeacherContract.GuestEntry.COLUME_FIO,
                TeacherContract.GuestEntry.COLUME_AGE,
                TeacherContract.GuestEntry.COLUME_SEX,
                TeacherContract.GuestEntry.COLUME_STATYS};

        Cursor cursor = db.query(TeacherContract.GuestEntry.TABLE_NAME,
                arrayColumn,
                null,
                null,
                null,
                null,
                null);

        int indexId = cursor.getColumnIndex(TeacherContract.GuestEntry.COLUME_ID);
        int indexFio = cursor.getColumnIndex(TeacherContract.GuestEntry.COLUME_FIO);
        int indexAge = cursor.getColumnIndex(TeacherContract.GuestEntry.COLUME_AGE);
        int indexSex = cursor.getColumnIndex(TeacherContract.GuestEntry.COLUME_SEX);
        int indexStatys = cursor.getColumnIndex(TeacherContract.GuestEntry.COLUME_STATYS);

        String columns = TeacherContract.GuestEntry.COLUME_ID + " " +
                TeacherContract.GuestEntry.COLUME_FIO + " " +
                TeacherContract.GuestEntry.COLUME_AGE + " " +
                TeacherContract.GuestEntry.COLUME_SEX + " " +
                TeacherContract.GuestEntry.COLUME_STATYS + " \n";
        tvStudents.append(columns);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(indexId);
            String fio = cursor.getString(indexFio);
            String sex = getResources()
                    .getStringArray(R.array.form_of_study)[cursor.getInt(indexSex)];
            String age = cursor.getString(indexAge);
            String statys = getResources()
                    .getStringArray(R.array.type_of_study)[cursor.getInt(indexStatys)];

            String row = String.valueOf(id) + " " +
                    fio + " " +
                    age + " " +
                    sex + " " +
                    statys + " \n";

            tvStudents.append(row);
        }

        cursor.close();
    }
}
