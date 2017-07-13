package com.example.fedet.entregableserviciowebybasededatos.Model.DAO;

import com.example.fedet.Util.ResultListener;
import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.Track;

import java.util.List;

/**
 * Created by fedet on 16/6/2017.
 */

public class DAOTrackInternet {

    public void getTrack (ResultListener<List<Track>> listener){
        Tarea tarea = new Tarea(listener);
        tarea.execute("https://api.myjson.com/bins/zwe9v");
    }
}
