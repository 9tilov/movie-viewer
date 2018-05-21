package com.example.toor.movieviewer.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.toor.movieviewer.App;
import com.example.toor.movieviewer.core.AppSchedulerProvider;
import com.example.toor.movieviewer.core.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class, NetworkModule.class})
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

    @Provides
    @Singleton
    SharedPreferences provideSplashViewModel(Context context) {
        return context.getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE);
    }

//    @Provides
//    @Singleton
//    AppDatabase provideAppDatabase(Context context) {
//        return Room.databaseBuilder(context,
//                AppDatabase.class, Constants.DB)
//                .allowMainThreadQueries()
//                .build();
//    }
}