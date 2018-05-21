package com.example.toor.movieviewer.di.module;

import com.example.toor.movieviewer.view.ui.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ScreenBuilder {

    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();
}
