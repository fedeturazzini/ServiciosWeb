package com.example.fedet.entregableserviciowebybasededatos.Controller;

import android.content.Context;

import com.example.fedet.Util.HTTPConnectionManager;
import com.example.fedet.Util.ResultListener;
import com.example.fedet.entregableserviciowebybasededatos.Model.DAO.DAOTrackDataBase;
import com.example.fedet.entregableserviciowebybasededatos.Model.DAO.DAOTrackInternet;
import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.Track;

import java.util.List;

/**
 * Created by fedet on 16/6/2017.
 */

public class ControllerTrack {

    public void getCard (final Context context, final ResultListener<List<Track>> listener){

        if (HTTPConnectionManager.isNetworkingOnline(context)){
            DAOTrackInternet daoTrackInternet = new DAOTrackInternet();
            daoTrackInternet.getTrack(new ResultListener<List<Track>>() {
                @Override
                public void finish(List<Track> resultado) {
                    DAOTrackDataBase daoTrackDataBase = new DAOTrackDataBase(context);
                    daoTrackDataBase.addListTrack(resultado);
                    listener.finish(resultado);
                }
            });
        } else {
            DAOTrackDataBase daoTrackDataBase = new DAOTrackDataBase(context);
            List<Track> trackList = daoTrackDataBase.getListTrackInDataBase();
            listener.finish(trackList);
        }
    }
}
