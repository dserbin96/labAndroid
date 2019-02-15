package com.example.dns.labandroid.labSQL.five;

import android.provider.BaseColumns;

public class StudentsContract {
    static class GuestEntry implements BaseColumns {
        public static final String TABLE_NAME = "students";
        public static final String COLUME_ID = BaseColumns._ID;
        public static final String COLUME_FIO = "Name";
        public static final String COLUME_COURSE = "Course";
        public static final String COLUME_AGE = "Age";
        public static final String COLUME_COUNTRY = "Country";
        public static final String COLUME_SEX = "Sex";
    }
}
