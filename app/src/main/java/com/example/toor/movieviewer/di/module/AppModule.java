package com.example.toor.movieviewer.di.module;

import android.content.Context;

import com.example.toor.movieviewer.App;
import com.example.toor.movieviewer.core.AppSchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class, NetworkModule.class, StorageModule.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    AppSchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}