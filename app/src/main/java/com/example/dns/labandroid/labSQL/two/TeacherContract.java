package com.example.dns.labandroid.labSQL.two;

import android.provider.BaseColumns;

public class TeacherContract {
    static class GuestEntry implements BaseColumns {
        public static final String TABLE_NAME = "patient";
        public static final String COLUME_ID = BaseColumns._ID;
        public static final String COLUME_FIO = "Name";
        public static final String COLUME_AGE = "Age";
        public static final String COLUME_SEX = "Sex";
        public static final String COLUME_STATYS = "Statys";
    }
}
