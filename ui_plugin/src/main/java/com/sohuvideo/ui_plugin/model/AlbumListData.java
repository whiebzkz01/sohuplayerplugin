package com.sohuvideo.ui_plugin.model;

import java.util.List;

/**
 * Created by shanli208820 on 2015/11/27.
 */
public class AlbumListData {
    private int count;
    private List<Video> videos;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
