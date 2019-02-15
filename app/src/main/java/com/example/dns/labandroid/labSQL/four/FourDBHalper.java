package com.example.dns.labandroid.labSQL.four;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FourDBHalper extends SQLiteOpenHelper {

    public FourDBHalper(Context context) {
        super(context, "hostel.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "create table " +
                DrafteeContract.GuestEntry.TABLE_NAME + " (" +
                DrafteeContract.GuestEntry.COLUME_ID + " integer primary key autoincrement," +
                DrafteeContract.GuestEntry.COLUME_FIO + " text not null," +
                DrafteeContract.GuestEntry.COLUME_AGE + " integer not null," +
                DrafteeContract.GuestEntry.COLUME_YEAR + " integer not null," +
                DrafteeContract.GuestEntry.COLUME_SITY + " text not null)";

        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
