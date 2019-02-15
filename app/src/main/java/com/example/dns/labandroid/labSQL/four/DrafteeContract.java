package com.example.dns.labandroid.labSQL.four;

import android.provider.BaseColumns;

public class DrafteeContract {
    static class GuestEntry implements BaseColumns {
        public static final String TABLE_NAME = "draftee";
        public static final String COLUME_ID = BaseColumns._ID;
        public static final String COLUME_FIO = "Name";
        public static final String COLUME_AGE = "Age";
        public static final String COLUME_SITY = "Sity";
        public static final String COLUME_YEAR = "Year";
    }
}
