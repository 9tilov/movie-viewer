package com.example.toor.movieviewer.model.db;

import android.arch.persistence.room.TypeConverter;

import com.example.toor.movieviewer.model.data.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Converters {

    @TypeConverter
    public static List<Movie> fromStringToMultimedia(String movies) {
        return new Gson().fromJson(movies, new TypeToken<List<Movie>>() {
        }.getType());
    }

    @TypeConverter
    public static String fromMultimediaToString(List<Movie> movies) {
        return new Gson().toJson(movies);
    }
}
