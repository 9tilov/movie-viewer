package com.example.toor.movieviewer.di.module;

import com.example.toor.movieviewer.view.ui.MainActivity;
import com.example.toor.movieviewer.view.ui.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ScreenBuilder {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();
}
