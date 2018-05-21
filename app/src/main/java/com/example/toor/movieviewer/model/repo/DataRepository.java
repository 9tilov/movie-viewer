package com.example.toor.movieviewer.model.repo;

import android.arch.lifecycle.MutableLiveData;

import com.example.toor.movieviewer.core.AppSchedulerProvider;
import com.example.toor.movieviewer.core.base.BaseViewModel;
import com.example.toor.movieviewer.model.api.Api;
import com.example.toor.movieviewer.model.data.Movie;
import com.example.toor.movieviewer.model.data.Movies;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class DataRepository implements BaseViewModel {

    private CompositeDisposable disposables = new CompositeDisposable();
    private final Api api;
    private final AppSchedulerProvider schedulerProvider;
    private final MutableLiveData<List<Movie>> moviewMutableLiveData;
    private final List<Movie> movies;

    @Inject
    DataRepository(Api api, AppSchedulerProvider schedulerProvider) {
        this.api = api;
        this.schedulerProvider = schedulerProvider;
        moviewMutableLiveData = new MutableLiveData<>();
        movies = new ArrayList<>();
        moviewMutableLiveData.postValue(movies);
    }

    public MutableLiveData<List<Movie>> getMoviewLiveList() {
        api.getMovies()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(new Observer<Movies>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Movies movies) {
                        moviewMutableLiveData.postValue(movies.getMovies());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d("Error");
                    }

                    @Override
                    public void onComplete() {
                        Timber.d("Complete");
                    }
                });
        return moviewMutableLiveData;
    }

    @Override
    public void onClear() {
        disposables.clear();
    }
}
