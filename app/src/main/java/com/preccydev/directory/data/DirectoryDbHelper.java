package com.preccydev.directory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_FIRSTNAME;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_GENDER;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_HALL;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_LASTNAME;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_LEVEL;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_PHONE_NUMBER;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.TABLE_NAME;


public class DirectoryDbHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "dir.db";
    private static final int DATABASE_VERSION = 1;

    public DirectoryDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createDb = "CREATE TABLE " + TABLE_NAME +"( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRSTNAME + " TEXT NOT NULL, " +
                COLUMN_LASTNAME + " TEXT NOT NULL, " +
                COLUMN_GENDER + " INTEGER NOT NULL, " +
                COLUMN_HALL + " INTEGER NOT NULL, " +
                COLUMN_LEVEL + " INTEGER NOT NULL, " +
                COLUMN_PHONE_NUMBER + " INTEGER NOT NULL DEFAULT 0 );";
        db.execSQL(createDb);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);

    }


}
