package com.example.toor.movieviewer.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.toor.movieviewer.model.data.Movie;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<Movie> selected = new MutableLiveData<Movie>();

    public void select(Movie item) {
        selected.setValue(item);
    }

    public LiveData<Movie> getSelected() {
        return selected;
    }
}
