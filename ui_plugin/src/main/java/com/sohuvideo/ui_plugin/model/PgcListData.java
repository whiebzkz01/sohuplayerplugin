package com.sohuvideo.ui_plugin.model;

import java.util.List;

public class PgcListData {

    private int count;
    private List<Pgc> videos;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Pgc> getVideos() {
        return videos;
    }

    public void setVideos(List<Pgc> videos) {
        this.videos = videos;
    }
}
