package com.example.dns.labandroid.labSQL.five;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FiveDBHalper extends SQLiteOpenHelper {

    public FiveDBHalper(Context context) {
        super(context, "hostel.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "create table " +
                StudentsContract.GuestEntry.TABLE_NAME + " (" +
                StudentsContract.GuestEntry.COLUME_ID + " integer primary key autoincrement," +
                StudentsContract.GuestEntry.COLUME_FIO + " text not null," +
                StudentsContract.GuestEntry.COLUME_AGE + " integer not null," +
                StudentsContract.GuestEntry.COLUME_COURSE + " integer not null," +
                StudentsContract.GuestEntry.COLUME_COUNTRY + " integer not null," +
                StudentsContract.GuestEntry.COLUME_SEX + " integer not null)";

        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
