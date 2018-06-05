package com.example.toor.movieviewer.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.toor.movieviewer.model.data.Movie;
import com.example.toor.movieviewer.model.repo.DataRepository;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private final LiveData<List<Movie>> movies;
    private final DataRepository repository;

    @Inject
    MainViewModel(DataRepository dataRepository) {
        this.repository = dataRepository;
        movies = dataRepository.getMovieLiveList();
    }

    public LiveData<List<Movie>> getMovieList() {
        return movies;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }
}
