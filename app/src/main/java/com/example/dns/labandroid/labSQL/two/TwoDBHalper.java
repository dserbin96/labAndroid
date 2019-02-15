package com.example.dns.labandroid.labSQL.two;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TwoDBHalper extends SQLiteOpenHelper {

    public TwoDBHalper(Context context) {
        super(context, "hostel.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "create table " +
                TeacherContract.GuestEntry.TABLE_NAME + " (" +
                TeacherContract.GuestEntry.COLUME_ID + " integer primary key autoincrement," +
                TeacherContract.GuestEntry.COLUME_FIO + " text not null," +
                TeacherContract.GuestEntry.COLUME_AGE + " text not null," +
                TeacherContract.GuestEntry.COLUME_SEX + " integer not null," +
                TeacherContract.GuestEntry.COLUME_STATYS + " integer not null)";

        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
