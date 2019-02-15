package com.example.dns.labandroid.labSQL.one;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dns.labandroid.R;

public class OneEnrolleeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_student);

        TextView tvStudents = findViewById(R.id.tvStudents);
        OneDBHalper dbHalper = new OneDBHalper(this);

        SQLiteDatabase db = dbHalper.getReadableDatabase();

        String[] arrayColumn = {
                EnrolleeContract.GuestEntry.COLUME_ID,
                EnrolleeContract.GuestEntry.COLUME_FIO,
                EnrolleeContract.GuestEntry.COLUME_RATING,
                EnrolleeContract.GuestEntry.COLUME_FORM_OF_STUDY,
                EnrolleeContract.GuestEntry.COLUME_TYPE_OF_STUDY};

        Cursor cursor = db.query(EnrolleeContract.GuestEntry.TABLE_NAME,
                arrayColumn,
                null,
                null,
                null,
                null,
                null);

        int indexId = cursor.getColumnIndex(EnrolleeContract.GuestEntry.COLUME_ID);
        int indexFio = cursor.getColumnIndex(EnrolleeContract.GuestEntry.COLUME_FIO);
        int indexRating = cursor.getColumnIndex(EnrolleeContract.GuestEntry.COLUME_RATING);
        int indexFormOfStudy = cursor.getColumnIndex(EnrolleeContract.GuestEntry.COLUME_FORM_OF_STUDY);
        int indexTypeOfStudy = cursor.getColumnIndex(EnrolleeContract.GuestEntry.COLUME_TYPE_OF_STUDY);

        String columns = EnrolleeContract.GuestEntry.COLUME_ID + " " +
                EnrolleeContract.GuestEntry.COLUME_FIO + " " +
                EnrolleeContract.GuestEntry.COLUME_RATING + " " +
                EnrolleeContract.GuestEntry.COLUME_FORM_OF_STUDY + " " +
                EnrolleeContract.GuestEntry.COLUME_TYPE_OF_STUDY + " \n";
        tvStudents.append(columns);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(indexId);
            String fio = cursor.getString(indexFio);
            String formOfStudy = getResources()
                    .getStringArray(R.array.form_of_study)[cursor.getInt(indexFormOfStudy)];
            String rating = cursor.getString(indexRating);
            String typeOfStudy = getResources()
                    .getStringArray(R.array.type_of_study)[cursor.getInt(indexTypeOfStudy)];

            String row = String.valueOf(id) + " " +
                    fio + " " +
                    rating + " " +
                    formOfStudy + " " +
                    typeOfStudy + " \n";

            tvStudents.append(row);
        }

        cursor.close();
    }
}
