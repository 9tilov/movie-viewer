package com.example.toor.movieviewer.model.db;

import android.arch.persistence.room.TypeConverter;

import com.example.toor.movieviewer.model.data.Multimedia;
import com.google.gson.Gson;

public class Converters {

    @TypeConverter
    public static Multimedia fromStringToMultimedia(String multimediaStr) {
        return new Gson().fromJson(multimediaStr, Multimedia.class);
    }

    @TypeConverter
    public static String fromMultimediaToString(Multimedia multimedia) {
        return new Gson().toJson(multimedia);
    }
}
