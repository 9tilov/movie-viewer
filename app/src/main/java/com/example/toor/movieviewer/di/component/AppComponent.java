package com.example.toor.movieviewer.di.component;

import com.example.toor.movieviewer.App;
import com.example.toor.movieviewer.di.module.AppModule;
import com.example.toor.movieviewer.di.module.ScreenBuilder;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ScreenBuilder.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}