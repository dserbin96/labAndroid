package com.example.dns.labandroid.labSQL.four;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dns.labandroid.R;

public class FourDrafteeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_student);

        TextView tvStudents = findViewById(R.id.tvStudents);
        FourDBHalper dbHalper = new FourDBHalper(this);

        SQLiteDatabase db = dbHalper.getReadableDatabase();

        String[] arrayColumn = {
                DrafteeContract.GuestEntry.COLUME_ID,
                DrafteeContract.GuestEntry.COLUME_FIO,
                DrafteeContract.GuestEntry.COLUME_AGE,
                DrafteeContract.GuestEntry.COLUME_YEAR,
                DrafteeContract.GuestEntry.COLUME_SITY};

        Cursor cursor = db.query(DrafteeContract.GuestEntry.TABLE_NAME,
                arrayColumn,
                null,
                null,
                null,
                null,
                null);

        int indexId = cursor.getColumnIndex(DrafteeContract.GuestEntry.COLUME_ID);
        int indexFio = cursor.getColumnIndex(DrafteeContract.GuestEntry.COLUME_FIO);
        int indexYear = cursor.getColumnIndex(DrafteeContract.GuestEntry.COLUME_YEAR);
        int indexAge = cursor.getColumnIndex(DrafteeContract.GuestEntry.COLUME_AGE);
        int indexSity = cursor.getColumnIndex(DrafteeContract.GuestEntry.COLUME_SITY);

        String columns = DrafteeContract.GuestEntry.COLUME_ID + " " +
                DrafteeContract.GuestEntry.COLUME_FIO + " " +
                DrafteeContract.GuestEntry.COLUME_AGE + " " +
                DrafteeContract.GuestEntry.COLUME_SITY + " " +
                DrafteeContract.GuestEntry.COLUME_YEAR + " \n";
        tvStudents.append(columns);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(indexId);
            String fio = cursor.getString(indexFio);
            int year = cursor.getInt(indexYear);
            int age = cursor.getInt(indexAge);
            String sity = cursor.getString(indexSity);

            String row = id + " " +
                    fio + " " +
                    age + " " +
                    sity + " " +
                    year + " \n";

            tvStudents.append(row);
        }
        cursor.close();
    }
}