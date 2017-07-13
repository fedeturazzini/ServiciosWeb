package com.example.fedet.entregableserviciowebybasededatos.Model.POJO;

/**
 * Created by fedet on 16/6/2017.
 */

public class Track {

    private Integer id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Track(Integer id, String title, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
