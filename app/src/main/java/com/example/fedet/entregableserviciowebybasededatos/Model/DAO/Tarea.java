package com.example.fedet.entregableserviciowebybasededatos.Model.DAO;

import android.os.AsyncTask;

import com.example.fedet.Util.DAOException;
import com.example.fedet.Util.HTTPConnectionManager;
import com.example.fedet.Util.ResultListener;
import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.Track;
import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.TrackContainer;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedet on 16/6/2017.
 */

public class Tarea extends AsyncTask<String, Void, List<Track>> {

    private ResultListener<List<Track>> listener;

    public Tarea(ResultListener<List<Track>> listener) {
        this.listener = listener;
    }

    @Override
    protected List<Track> doInBackground(String... params) {

        String url = params [0];
        List <Track> listTrack = new ArrayList<>();

        HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
        try {
            InputStream inputStream = httpConnectionManager.getRequestStream(url);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            Gson gson = new Gson();
            TrackContainer trackContainer = gson.fromJson(bufferedReader, TrackContainer.class);
            listTrack = trackContainer.getListTrack();

        } catch (DAOException e) {
            e.printStackTrace();
        }
        httpConnectionManager.closeConnection();
        return listTrack;
    }

    @Override
    protected void onPostExecute(List<Track> tracks) {
        listener.finish(tracks);
    }
}
