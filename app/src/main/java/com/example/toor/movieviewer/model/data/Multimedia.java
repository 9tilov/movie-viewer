package com.example.toor.movieviewer.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Multimedia {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
