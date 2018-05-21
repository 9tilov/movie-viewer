package com.example.toor.movieviewer.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {

    @SerializedName("results")
    @Expose
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
