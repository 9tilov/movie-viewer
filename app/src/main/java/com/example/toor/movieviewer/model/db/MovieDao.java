package com.example.toor.movieviewer.model.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.toor.movieviewer.model.data.Movie;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    Flowable<List<Movie>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Movie> articles);

    @Query("DELETE FROM movie")
    void clear();

    @Query("SELECT * FROM movie WHERE id == :id")
    LiveData<Movie> get(int id);
}
