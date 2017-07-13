package com.example.fedet.entregableserviciowebybasededatos.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedet on 16/6/2017.
 */

public class TrackContainer {

    @SerializedName("tracks")
    private List <Track> listTrack = new ArrayList<>();

    public List<Track> getListTrack() {
        return listTrack;
    }
}
