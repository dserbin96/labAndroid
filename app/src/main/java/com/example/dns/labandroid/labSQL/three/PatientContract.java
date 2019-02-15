package com.example.dns.labandroid.labSQL.three;

import android.provider.BaseColumns;

public class PatientContract {
    static class GuestEntry implements BaseColumns {
        public static final String TABLE_NAME = "enrollee";
        public static final String COLUME_ID = BaseColumns._ID;
        public static final String COLUME_FIO = "Name";
        public static final String COLUME_AGE = "Age";
        public static final String COLUME_BLOOD = "Blood";
        public static final String COLUME_TYPE_BLOOD = "Type_blood";
    }
}
