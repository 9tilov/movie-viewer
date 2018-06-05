package com.example.toor.movieviewer.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.toor.movieviewer.model.data.Movie;

@Database(entities = {Movie.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
}
