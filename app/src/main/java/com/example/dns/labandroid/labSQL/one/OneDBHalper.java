package com.example.dns.labandroid.labSQL.one;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OneDBHalper extends SQLiteOpenHelper {

    public OneDBHalper(Context context) {
        super(context, "hostel.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "create table " +
                EnrolleeContract.GuestEntry.TABLE_NAME + " (" +
                EnrolleeContract.GuestEntry.COLUME_ID + " integer primary key autoincrement," +
                EnrolleeContract.GuestEntry.COLUME_FIO + " text not null," +
                EnrolleeContract.GuestEntry.COLUME_RATING + " text not null," +
                EnrolleeContract.GuestEntry.COLUME_FORM_OF_STUDY + " integer not null," +
                EnrolleeContract.GuestEntry.COLUME_TYPE_OF_STUDY + " integer not null)";

        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
