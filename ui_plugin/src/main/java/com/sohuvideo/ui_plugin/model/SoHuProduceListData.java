package com.sohuvideo.ui_plugin.model;

import java.util.List;


public class SoHuProduceListData {
    private int count;
    private List<SohuProduce> videos;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SohuProduce> getVideos() {
        return videos;
    }

    public void setVideos(List<SohuProduce> videos) {
        this.videos = videos;
    }
}
