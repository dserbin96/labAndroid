package com.example.dns.labandroid.labSQL.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//создаваемая база данных
public class ExampleDBHalper extends SQLiteOpenHelper {

    public ExampleDBHalper(Context context) {
        super(context, "hostel.db", null, 1);
    }

    //метод для создания БД
    @Override
    public void onCreate(SQLiteDatabase db) {
        //создаем текстом команду по созданию таблици в бд
        String createSQL = "create table " +
                HostelContract.GuestEntry.TABLE_NAME + " (" +
                HostelContract.GuestEntry.COLUME_ID + " integer primary key autoincrement," +
                HostelContract.GuestEntry.COLUME_FIO + " text not null," +
                HostelContract.GuestEntry.COLUME_AGE + " integer not null," +
                HostelContract.GuestEntry.COLUME_GROUP + " text not null," +
                HostelContract.GuestEntry.COLUME_NUMBER_HOSTEL + " integer )";

        //перекидываем команду в БД
        db.execSQL(createSQL);
    }

    //метод для обновление БД
    //используется если изменилась версия бд в приложениии
    //важный метод, при изменеии таблици он позволяет аккуратно изменить БД
    //при его неиспользовании может произойти краш приложения
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
