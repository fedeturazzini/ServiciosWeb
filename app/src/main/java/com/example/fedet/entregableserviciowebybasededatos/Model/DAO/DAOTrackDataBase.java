package com.example.fedet.entregableserviciowebybasededatos.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedet on 19/6/2017.
 */

public class DAOTrackDataBase extends DataBaseHelper {

    public DAOTrackDataBase(Context context) {
        super(context);
    }

    public static final String TABLE_NAME = "Tracks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "titleTrack";
    public static final String COLUMN_IMAGE = "imageTrack";

    public void addTrack(Track track){

        if (!existInDB(track.getId())){
            SQLiteDatabase database = getWritableDatabase();
            // EL content values es como un bundle
            ContentValues row = new ContentValues();
            row.put(COLUMN_ID, track.getId());
            row.put(COLUMN_IMAGE, track.getThumbnailUrl());
            row.put(COLUMN_TITLE, track.getTitle());

            database.insert(TABLE_NAME, null, row);

            database.close();
        }
    }

    public void addListTrack (List<Track> tracks){
        for (Track track: tracks){
            addTrack(track);
        }
    }

    public Boolean existInDB (Integer id) {

        SQLiteDatabase database = getReadableDatabase();
        String query = "SELECT " + COLUMN_ID + " FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + "'" + id + "'";

        Cursor cursor = database.rawQuery(query, null);

        Boolean validate = cursor.moveToNext();

        database.close();
        cursor.close();
        return validate;
    }


    public List<Track> getListTrackInDataBase (){
        List<Track> tracks = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = database.rawQuery(query, null);

        while (cursor.moveToNext()){
            Integer id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));
            String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
            Track track = new Track(id, title, image);
            tracks.add(track);
        }

        database.close();
        cursor.close();
        return tracks;
    }

}
