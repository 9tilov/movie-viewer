package com.example.toor.movieviewer.model.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.toor.movieviewer.model.data.Movies;

import io.reactivex.Flowable;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movies")
    Flowable<Movies> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movies articles);

    @Query("DELETE FROM movies")
    void clear();

    @Query("SELECT * FROM movies WHERE id == :id")
    LiveData<Movies> get(int id);
}
