package com.example.toor.movieviewer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.toor.movieviewer.di.component.DaggerAppComponent;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    public Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initDagger();
        Timber.plant(new Timber.DebugTree());
        Stetho.initializeWithDefaults(this);
        context = getApplicationContext();
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    private void initDagger() {
        DaggerAppComponent.builder().create(this).inject(this);
    }
}
