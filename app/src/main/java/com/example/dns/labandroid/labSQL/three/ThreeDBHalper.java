package com.example.dns.labandroid.labSQL.three;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ThreeDBHalper extends SQLiteOpenHelper {

    public ThreeDBHalper(Context context) {
        super(context, "hostel.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "create table " +
                PatientContract.GuestEntry.TABLE_NAME + " (" +
                PatientContract.GuestEntry.COLUME_ID + " integer primary key autoincrement," +
                PatientContract.GuestEntry.COLUME_FIO + " text not null," +
                PatientContract.GuestEntry.COLUME_AGE + " text not null," +
                PatientContract.GuestEntry.COLUME_BLOOD + " integer not null," +
                PatientContract.GuestEntry.COLUME_TYPE_BLOOD + " boolean not null)";

        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
