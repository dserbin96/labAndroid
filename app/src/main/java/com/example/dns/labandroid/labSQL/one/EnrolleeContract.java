package com.example.dns.labandroid.labSQL.one;

import android.provider.BaseColumns;

public class EnrolleeContract {
    static class GuestEntry implements BaseColumns {
        public static final String TABLE_NAME = "enrollee";
        public static final String COLUME_ID = BaseColumns._ID;
        public static final String COLUME_FIO = "Name";
        public static final String COLUME_RATING = "Rating";
        public static final String COLUME_FORM_OF_STUDY = "Form_of_study";
        public static final String COLUME_TYPE_OF_STUDY = "Type_of_study";
    }
}
