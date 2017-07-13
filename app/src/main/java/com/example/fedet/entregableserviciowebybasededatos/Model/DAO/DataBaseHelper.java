package com.example.fedet.entregableserviciowebybasededatos.Model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fedet on 19/6/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "track_database";
    public static final Integer DATABASE_VERSION = 1;


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DAOTrackDataBase.TABLE_NAME +
                " (" +  DAOTrackDataBase.COLUMN_ID + " INTEGER PRIMARY KEY, " + DAOTrackDataBase.COLUMN_TITLE + " TEXT NOT NULL, " +
                DAOTrackDataBase.COLUMN_IMAGE + " TEXT NOT NULL);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
