package com.example.toor.movieviewer.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.toor.movieviewer.model.data.Movie;
import com.example.toor.movieviewer.model.data.Movies;
import com.example.toor.movieviewer.model.repo.DataRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Movies> movies = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final DataRepository repository;

    @Inject
    MainViewModel(DataRepository dataRepository) {
        this.repository = dataRepository;
        loadMovies();
    }

    private void loadMovies() {
        compositeDisposable.add(repository.getMovieLiveList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies1 -> movies.setValue(movies1), t -> Timber.d(t, "get comments error = " + t.getMessage())));
    }

    public MutableLiveData<Movies> getMovieList() {
        return movies;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
