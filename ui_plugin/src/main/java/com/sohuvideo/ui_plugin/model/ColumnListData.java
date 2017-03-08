package com.sohuvideo.ui_plugin.model;

import java.util.List;

public class ColumnListData {

    private String column_name;
    private int category_code;
    private List<Column> videos;

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public List<Column> getVideos() {
        return videos;
    }

    public void setVideos(List<Column> videos) {
        this.videos = videos;
    }
}
