package com.example.dns.labandroid.labSQL.example;

import android.provider.BaseColumns;
//класс внутри которого содержиться вся информация о создаваемой БД
public class HostelContract {
    static class GuestEntry implements BaseColumns {
        public static final String TABLE_NAME = "hostal";
        public static final String COLUME_ID = BaseColumns._ID;
        public static final String COLUME_FIO = "Name";
        public static final String COLUME_NUMBER_HOSTEL = "NumberHostel";
        public static final String COLUME_AGE = "Age";
        public static final String COLUME_GROUP = "NameGroup";
    }
}
