package com.example.toor.movieviewer.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.toor.movieviewer.core.Constants;
import com.example.toor.movieviewer.model.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB)
                .allowMainThreadQueries()
                .build();
    }
}
