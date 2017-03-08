package com.sohuvideo.ui_plugin.model;

import java.util.List;


public class ItemModel {
    public static final int VIEW_TYPE_COUNT = 3;
    public static final int ITEM_TYPE_NORMAL_TITLE = 0; //标题
    public static final int ITEM_TYPE_NORMAL_VIDEO_LIST = 1; //视频
    public static final int ITEM_TYPE_VIDEO_LIST_SEPARATOR = 2; //分隔线


    private int itemType;
    private int category_code;
    private String title;
    private List<Column> mColumnList;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Column> getmColumnList() {
        return mColumnList;
    }

    public void setmColumnList(List<Column> mColumnList) {
        this.mColumnList = mColumnList;
    }
}
