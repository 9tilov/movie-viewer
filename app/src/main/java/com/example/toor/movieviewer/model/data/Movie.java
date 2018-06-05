package com.example.toor.movieviewer.model.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("display_title")
    @Expose
    private String displayTitle;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @SerializedName("critics_pick")
    @Expose
    private int criticsPick;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("summary_short")
    @Expose
    private String summaryShort;
    @SerializedName("publication_date")
    @Expose
    private String publicationDate;
    @SerializedName("opening_date")
    @Expose
    private String openingDate;
    @SerializedName("date_updated")
    @Expose
    private String dateUpdated;
    @SerializedName("multimedia")
    @Expose
    private Multimedia multimedia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public int getCriticsPick() {
        return criticsPick;
    }

    public void setCriticsPick(int criticsPick) {
        this.criticsPick = criticsPick;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummaryShort() {
        return summaryShort;
    }

    public void setSummaryShort(String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }
}
