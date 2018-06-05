package com.example.toor.movieviewer.model.api;

import com.example.toor.movieviewer.model.data.Movie;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

import static com.example.toor.movieviewer.core.Constants.API_KEY;

public interface Api {

    @GET("reviews/search.json?api-key=" + API_KEY)
    Single<List<Movie>> getMovies();
}
