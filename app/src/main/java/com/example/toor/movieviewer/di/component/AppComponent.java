package com.example.toor.movieviewer.di.component;

import android.app.Application;

import com.example.toor.movieviewer.App;
import com.example.toor.movieviewer.di.module.AppModule;
import com.example.toor.movieviewer.di.module.NetworkModule;
import com.example.toor.movieviewer.di.module.ScreenBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules={NetworkModule.class, ScreenBuilder.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}