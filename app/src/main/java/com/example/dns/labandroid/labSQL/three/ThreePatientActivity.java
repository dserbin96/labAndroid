package com.example.dns.labandroid.labSQL.three;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dns.labandroid.R;

public class ThreePatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_student);

        TextView tvStudents = findViewById(R.id.tvStudents);
        ThreeDBHalper dbHalper = new ThreeDBHalper(this);

        SQLiteDatabase db = dbHalper.getReadableDatabase();

        String[] arrayColumn = {
                PatientContract.GuestEntry.COLUME_ID,
                PatientContract.GuestEntry.COLUME_FIO,
                PatientContract.GuestEntry.COLUME_AGE,
                PatientContract.GuestEntry.COLUME_BLOOD,
                PatientContract.GuestEntry.COLUME_TYPE_BLOOD};

        Cursor cursor = db.query(PatientContract.GuestEntry.TABLE_NAME,
                arrayColumn,
                null,
                null,
                null,
                null,
                null);

        int indexId = cursor.getColumnIndex(PatientContract.GuestEntry.COLUME_ID);
        int indexFio = cursor.getColumnIndex(PatientContract.GuestEntry.COLUME_FIO);
        int indexAge = cursor.getColumnIndex(PatientContract.GuestEntry.COLUME_AGE);
        int indexBlood = cursor.getColumnIndex(PatientContract.GuestEntry.COLUME_BLOOD);
        int indexTypeBlood = cursor.getColumnIndex(PatientContract.GuestEntry.COLUME_TYPE_BLOOD);

        String columns = PatientContract.GuestEntry.COLUME_ID + " " +
                PatientContract.GuestEntry.COLUME_FIO + " " +
                PatientContract.GuestEntry.COLUME_AGE + " " +
                PatientContract.GuestEntry.COLUME_BLOOD + " " +
                PatientContract.GuestEntry.COLUME_TYPE_BLOOD + " \n";
        tvStudents.append(columns);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(indexId);
            String fio = cursor.getString(indexFio);
            String blood = getResources()
                    .getStringArray(R.array.blood)[cursor.getInt(indexBlood)];
            String age = cursor.getString(indexAge);
            String bloodType = cursor.getInt(indexTypeBlood) == 1 ? getString(R.string.positive)
                    : getString(R.string.negative);

            String row = id + " " +
                    fio + " " +
                    age + " " +
                    blood + " " +
                    bloodType + " \n";

            tvStudents.append(row);
        }

        cursor.close();
    }
}
