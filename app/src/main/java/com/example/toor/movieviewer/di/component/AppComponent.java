package com.example.toor.movieviewer.di.component;

import com.example.toor.movieviewer.App;
import com.example.toor.movieviewer.di.module.ActivityModule;
import com.example.toor.movieviewer.di.module.AppModule;
import com.example.toor.movieviewer.di.module.FragmentModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, FragmentModule.class})
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}