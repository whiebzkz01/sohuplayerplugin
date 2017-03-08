package com.sohuvideo.ui_plugin.model;

/**
 * Created by shanli208820 on 2015/11/27.
 */
public class AlbumData {
    private long aid;
    private String album_name;
    private long play_count;
    private String album_desc;
    private String director;
    private String actor;
    private String area;
    private String score;//评分
    private String second_cate_name;//剧集类型
    private String update_notification;//更新时间
    private int year;
    private int total_video_count;
    private int latest_video_count;

    @Override
    public String toString() {
        return "AlbumData{" +
                "aid=" + aid +
                ", album_name='" + album_name + '\'' +
                ", play_count=" + play_count +
                ", album_desc='" + album_desc + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", area='" + area + '\'' +
                ", score='" + score + '\'' +
                ", second_cate_name='" + second_cate_name + '\'' +
                ", update_notification='" + update_notification + '\'' +
                ", year=" + year +
                ", total_video_count=" + total_video_count +
                ", latest_video_count=" + latest_video_count +
                '}';
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public long getPlay_count() {
        return play_count;
    }

    public void setPlay_count(long play_count) {
        this.play_count = play_count;
    }

    public String getAlbum_desc() {
        return album_desc;
    }

    public void setAlbum_desc(String album_desc) {
        this.album_desc = album_desc;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotal_video_count() {
        return total_video_count;
    }

    public void setTotal_video_count(int total_video_count) {
        this.total_video_count = total_video_count;
    }

    public int getLatest_video_count() {
        return latest_video_count;
    }

    public void setLatest_video_count(int latest_video_count) {
        this.latest_video_count = latest_video_count;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSecond_cate_name() {
        return second_cate_name;
    }

    public void setSecond_cate_name(String second_cate_name) {
        this.second_cate_name = second_cate_name;
    }

    public String getUpdate_notification() {
        return update_notification;
    }

    public void setUpdate_notification(String update_notification) {
        this.update_notification = update_notification;
    }
}
