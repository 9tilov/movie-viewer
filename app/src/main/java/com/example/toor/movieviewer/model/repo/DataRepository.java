package com.example.toor.movieviewer.model.repo;

import com.example.toor.movieviewer.core.base.BaseViewModel;
import com.example.toor.movieviewer.model.api.Api;
import com.example.toor.movieviewer.model.data.Movie;
import com.example.toor.movieviewer.model.data.Movies;
import com.example.toor.movieviewer.model.db.AppDatabase;
import com.example.toor.movieviewer.model.db.MovieDao;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

@Singleton
public class DataRepository implements BaseViewModel {

    private CompositeDisposable disposables = new CompositeDisposable();
    private final Api api;
    private final MovieDao movieDao;

    @Inject
    public DataRepository(AppDatabase database, Api api) {
        this.api = api;
        this.movieDao = database.movieDao();
    }

    public Flowable<Movies> getMovieLiveList() {
        Timber.d("aaa23");
//        Flowable<List<Movie>> movies = Flowable.create(emitter -> new NetworkBoundSource<List<Movie>, List<Movie>>(emitter) {
//
//            @Override
//            public Flowable<List<Movie>> getRemote() {
//                return api.getMovies();
//            }
//
//            @Override
//            public Flowable<List<Movie>> getLocal() {
//                return movieDao.getAll();
//            }
//
//            @Override
//            public void saveCallResult(List<Movie> data) {
//                int a = data.size();
//                int b = 1;
//            }
//
//            @Override
//            public Function<List<Movie>, List<Movie>> mapper() {
//                return movies1 -> movies1;
//            }
//        }, BackpressureStrategy.BUFFER);
        return Flowable.merge(getFromDb(), getFromNetwork());
    }

    private Flowable<Movies> getFromDb() {
        return movieDao.getAll();
    }

    private Flowable<Movies> getFromNetwork() {
        return api.getMovies()
                .doOnSuccess(movieDao::insert).toFlowable()
                .doOnError(throwable -> Timber.d("moggot = " + throwable.getMessage()));
    }

    @Override
    public void onClear() {
        disposables.clear();
    }
}
