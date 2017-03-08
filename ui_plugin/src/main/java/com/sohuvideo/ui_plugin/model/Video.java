package com.sohuvideo.ui_plugin.model;

/**
 * Created by shanli208820 on 2015/11/27.
 */
public class Video {

    private long vid;
    private long aid;
    private int site;
    private String video_name;

   public long getVid() {
        return vid;
    }

    public void setVid(long vid) {
        this.vid = vid;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    @Override
    public String toString() {
        return "Video{" +
                "vid=" + vid +
                ", aid=" + aid +
                ", site=" + site +
                ", video_name='" + video_name + '\'' +
                '}';
    }
}
