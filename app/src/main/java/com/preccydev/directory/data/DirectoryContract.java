package com.preccydev.directory.data;

import android.provider.BaseColumns;

import com.preccydev.directory.DirectoryUpdate;


public class DirectoryContract {
    public static abstract class DirectoryEntry implements BaseColumns {
        public final static String TABLE_NAME = "fsfui";
        public static final String _ID = BaseColumns._ID;
        public final static String COLUMN_FIRSTNAME = "firstName";
        public final static String COLUMN_LASTNAME = "lastNamae";
        public final static String COLUMN_HALL = "hallname";
        public final static String COLUMN_GENDER = "gender";
        public final static String COLUMN_LEVEL = "level";
        public final static String COLUMN_PHONE_NUMBER = "phoneNumber";

        //int for the gender options
        public final static int GENDER_MALE = 1;
        public final static int GENDER_FEMALE = 2;

        //int for the Hall options
        public final static int HALL_KUTI = 1;
        public final static int HALL_BELLO = 2;
        public final static int HALL_MELLANBY = 3;
        public final static int HALL_TEDDER = 4;
        public final static int HALL_INDEPENDENCE = 5;
        public final static int HALL_NNAMDI = 6;
        public final static int HALL_QUEEN_ELIZABETH = 7;
        public final static int HALL_QUEEN_IDIA = 8;
        public final static int HALL_AWO = 9;
        public final static int HALL_OFF_CAMPUS = 10;

    }
}
